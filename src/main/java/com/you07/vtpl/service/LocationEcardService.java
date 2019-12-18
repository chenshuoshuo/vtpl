package com.you07.vtpl.service;

import com.you07.eas.model.StudentInfo;
import com.you07.eas.model.TeacherInfo;
import com.you07.eas.service.StudentInfoService;
import com.you07.eas.service.TeacherInfoService;
import com.you07.map.service.MapService;
import com.you07.map.vo.MapInfoVO;
import com.you07.vtpl.VTPLException;
import com.you07.vtpl.dao.LocationCampusInfoDao;
import com.you07.vtpl.dao.LocationEcardDeviceDao;
import com.you07.vtpl.dao.LocationEcardUseRecordDao;
import com.you07.vtpl.dao.LocationLatestDao;
import com.you07.vtpl.model.LocationCampusInfo;
import com.you07.vtpl.model.LocationEcardDevice;
import com.you07.vtpl.model.LocationEcardUseRecord;
import com.you07.vtpl.model.LocationLatest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author egan
 * @date 2019/11/29 10:56
 * @desc
 */
@Service
public class LocationEcardService {

    private final LocationEcardDeviceDao locationEcardDeviceDao;

    private final LocationEcardUseRecordDao locationEcardUseRecordDao;

    private final LocationLatestDao locationLatestDao;

    private final MapService mapService;

    private static StudentInfoService studentInfoService;

    private static TeacherInfoService teacherInfoService;

    private final LocationCampusInfoDao campusInfoDao;

    @Value("${ecard.max-data-count}")
    private Integer maxDataCount;

    private static Logger logger = LoggerFactory.getLogger(LocationEcardService.class);

    private static Map<String, StudentInfo> studentMap = null;
    private static Map<String, TeacherInfo> teacherMap = null;

    @Autowired
    public LocationEcardService(LocationEcardDeviceDao locationEcardDeviceDao, LocationEcardUseRecordDao locationEcardUseRecordDao, LocationLatestDao locationLatestDao, MapService mapService, StudentInfoService studentInfoService, TeacherInfoService teacherInfoService, LocationCampusInfoDao campusInfoDao) {
        this.locationEcardDeviceDao = locationEcardDeviceDao;
        this.locationEcardUseRecordDao = locationEcardUseRecordDao;
        this.locationLatestDao = locationLatestDao;
        this.mapService = mapService;
        LocationEcardService.studentInfoService = studentInfoService;
        this.teacherInfoService = teacherInfoService;
        this.campusInfoDao = campusInfoDao;
    }


    /**
     * egan
     * 将一卡通使用记录转换成最后点位保存在latest_location表中
     *
     * @param
     * @date 2019/11/29 11:05
     **/
    @Transactional
    public synchronized void saveEcardRecord() {


        long startTime = System.currentTimeMillis();
        //每次限制存若干条
        List<LocationEcardUseRecord> records = locationEcardUseRecordDao.selectEcardList(maxDataCount);
        //如果有数据，转换成location_latest
        List<LocationLatest> locationLatests = new ArrayList<>();
        for (LocationEcardUseRecord r : records) {
            LocationEcardDevice device = locationEcardDeviceDao.selectByPrimaryKey(r.getDeviceCode());
            LocationLatest locationLatest = new LocationLatest();
            try {
                if (device == null) {
                    throw new VTPLException("未识别设备：" + r.getDeviceCode());
                }
                if ("设备错误".equals(device.getMemo())) {
                    throw new VTPLException("设备" + device.getDeviceCode() + "不可用，请先检查设备");
                }
                if (device.getDeviceLat() == null || device.getDeviceLng() == null) {
                    MapInfoVO mapInfoVO = mapService.queryFloorCenterLngLat(device.getInstallCampus(), device.getInstallBuilding(), device.getInstallRoom());
                    try {
                        //如果无法获取到经纬度，跳过该记录
                        device.setDeviceLng(mapInfoVO.getCenter().getX());
                        device.setDeviceLat(mapInfoVO.getCenter().getY());
                        if (StringUtils.isNotBlank(mapInfoVO.getLevel()))
                            device.setGisLeaf(Integer.parseInt(mapInfoVO.getLevel()));
                        locationEcardDeviceDao.updateByPrimaryKey(device);
                    } catch (Exception e) {
                        device.setMemo("设备错误");
                        locationEcardDeviceDao.updateByPrimaryKey(device);
                        logger.warn("获取经纬度失败:" + device.getDeviceCode(), e);
                        e.printStackTrace();
                        continue;
                    }
                }
                LocationCampusInfo locationCampusInfo = campusInfoDao.selectOneByName(device.getInstallCampus());
                if (locationCampusInfo == null) {
                    throw new VTPLException("校区不存在:" + device.getInstallCampus());
                }
                locationLatest.setZoneId(String.valueOf(locationCampusInfo.getCampusId()));

                locationLatest.setUserid(r.getUserCode());
                locationLatest.setLocationTime(r.getUseTime());
                locationLatest.setAccountMac(r.getEcardNo());

                //如果无法获取到学工信息，跳过该记录
                //从缓存中获取学工数据
                TeacherInfo teacherInfo = getTeacherFromMap(r.getUserCode());
                StudentInfo studentInfo = getStudentFromMap(r.getUserCode());
                if (studentInfo != null && studentInfo.getStudentno() != null) {
                    locationLatest.setDataByStudentInfo(studentInfo);
                }else if(teacherInfo != null && teacherInfo.getTeachercode()!= null) {
                    locationLatest.setDataByTeacherInfo(teacherInfo);
                }else {
                    throw new VTPLException("学工信息不存在:" + r.getUserCode());

                }
            } catch (VTPLException ve) {
                logger.warn("数据转换失败:" + ve.getMessage());
                continue;
            } catch (Exception e) {
                logger.warn("接收一卡通数据时发生未知错误", e);
                continue;
            }
            locationLatest.setInSchool(1);
            locationLatest.setLng(device.getDeviceLng());
            locationLatest.setLat(device.getDeviceLat());
            locationLatest.setFloorid(String.valueOf(device.getGisLeaf()));
            locationLatest.setUsrUpdateTime(new Date(System.currentTimeMillis()));

            locationLatests.add(locationLatest);
        }
        if (locationLatests.size() > 0)
            locationLatestDao.deleteBatchById(covertListStringToInSQL(locationLatests.stream().map(LocationLatest::getUserid).collect(Collectors.toList())));
        if (locationLatests.size() > 1) {
            locationLatestDao.insertBatch(locationLatests);
        } else if (locationLatests.size() == 1) {
            locationLatestDao.insert(locationLatests.get(0));
        }
        locationEcardUseRecordDao.deleteBatchById(covertListStringToInSQL(records.stream().map(LocationEcardUseRecord::getRecordCode).collect(Collectors.toList())));

        logger.info("一卡通定时器执行了一个任务，用时" + (System.currentTimeMillis() - startTime) / 1000 + "s");
    }

    public static void clear() {
        studentMap = null;
        teacherMap = null;
    }

    private static StudentInfo getStudentFromMap(String id) {
        try {
            if (studentMap == null) {
                studentMap = studentInfoService.generateStudentMap(50000);
                logger.info("初始化学生数据：" + studentMap.size() + " 条");
            }
            return studentMap.get(id);
        } catch (IOException e) {
            logger.error("无法获取学生信息");
            throw new RuntimeException(e);
        }
    }

    private static TeacherInfo getTeacherFromMap(String id) {
        try {
            if (teacherMap == null) {
                teacherMap = teacherInfoService.generateMap(50000);
                logger.info("初始化教职工数据：" + teacherMap.size() + " 条");
            }
            return teacherMap.get(id);
        } catch (IOException e) {
            logger.error("无法获取教职工信息");
            throw new RuntimeException(e);
        }
    }

    private static String covertListStringToInSQL(List list) {
        if (list == null || list.size() == 0)
            return "";
        StringBuilder inSQL = new StringBuilder();
        inSQL.append("'").append(list.get(0)).append("'");
        for (int i = 1; i < list.size(); i++)
            inSQL.append(",'").append(list.get(i)).append("'");
        return inSQL.toString();
    }
}
