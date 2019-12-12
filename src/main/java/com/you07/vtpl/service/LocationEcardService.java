package com.you07.vtpl.service;

import com.you07.eas.model.StudentInfo;
import com.you07.eas.service.StudentInfoService;
import com.you07.eas.service.TeacherInfoService;
import com.you07.map.service.MapService;
import com.you07.map.vo.MapInfoVO;
import com.you07.vtpl.dao.LocationEcardDeviceDao;
import com.you07.vtpl.dao.LocationEcardUseRecordDao;
import com.you07.vtpl.dao.LocationLatestDao;
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

    @Autowired
    private LocationEcardDeviceDao locationEcardDeviceDao;

    @Autowired
    private LocationEcardUseRecordDao locationEcardUseRecordDao;

    @Autowired
    private LocationLatestDao locationLatestDao;

    @Autowired
    private MapService mapService;

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Value("${ecard.max-data-count}")
    private Integer maxDataCount;

    private Logger logger = LoggerFactory.getLogger(LocationEcardService.class);

    private static Map<String, StudentInfo> stuMap = null;


    /**
     * egan
     * 将一卡通使用记录转换成最后点位保存在latest_location表中
     *
     * @param
     * @date 2019/11/29 11:05
     **/
    @Transactional
    public synchronized void saveEcardRecord() {
        if (stuMap == null) {
            stuMap = getStuMap(50000);
            logger.info("初始化学生数据");
        }

        long startTime = System.currentTimeMillis();
        //每次限制存若干条条
        List<LocationEcardUseRecord> records = locationEcardUseRecordDao.selectEcardList(maxDataCount);
        //如果有数据，转换成location_latest
        List<LocationLatest> locationLatests = new ArrayList<>();
        for (LocationEcardUseRecord r : records) {
            LocationEcardDevice device = locationEcardDeviceDao.selectByPrimaryKey(r.getDeviceCode());
            LocationLatest locationLatest = new LocationLatest();
            if (device == null) {
                throw new RuntimeException("未识别设备："+r.getDeviceCode());
            }
            if (device.getDeviceLat() == null || device.getDeviceLng() == null) {
                MapInfoVO mapInfoVO = mapService.queryFloorCenterLngLat(device.getInstallCampus(), device.getInstallBuilding(), device.getInstallRoom());
                try {
                    locationLatest.setZoneId(mapInfoVO.getZoneId());
                    //如果无法获取到经纬度，跳过该记录
                    device.setDeviceLat(mapInfoVO.getCenter().getX());
                    device.setDeviceLng(mapInfoVO.getCenter().getX());
                    if (StringUtils.isNotBlank(mapInfoVO.getLevel()))
                        device.setGisLeaf(Integer.parseInt(mapInfoVO.getLevel()));
                    locationEcardDeviceDao.updateByPrimaryKey(device);
                } catch (Exception e) {
                    logger.warn("获取经纬度失败", e);
                    e.printStackTrace();
                    continue;
                }
            }

            locationLatest.setUserid(r.getUserCode());
            try {
                //如果无法获取到学工信息，跳过该记录
                //先尝试从缓存中获取学生数据
                StudentInfo studentInfo = stuMap.get(r.getUserCode());
                if (studentInfo != null && studentInfo.getStudentno() != null) {
                    locationLatest.setDataByStudentInfo(studentInfo);
                } else {
                    throw new RuntimeException("学工信息不存在:" + r.getUserCode());
//                    //如果缓存中不存在，到cmips进行网络请求
//                    studentInfo = studentInfoService.get(r.getUserCode());
//                    if (studentInfo != null && studentInfo.getStudentno() != null) {
//                        locationLatest.setDataByStudentInfo(studentInfo);
//                    } else {
//                        TeacherInfo teacherInfo = teacherInfoService.get(r.getUserCode());
//                        if (teacherInfo == null || StringUtils.isBlank(teacherInfo.getTeachercode()))
//                            throw new RuntimeException("学工信息不存在:" + r.getUserCode());
//                        locationLatest.setDataByTeacherInfo(teacherInfo);
//                    }
                }
            } catch (Exception e) {
                logger.warn(e.getMessage());
                e.printStackTrace();
                continue;
            }
            locationLatest.setInSchool(1);
            locationLatest.setLng(device.getDeviceLng());
            locationLatest.setLat(device.getDeviceLat());
            locationLatest.setFloorid(String.valueOf(device.getGisLeaf()));
            locationLatest.setUsrUpdateTime(new Date(System.currentTimeMillis()));

            locationLatests.add(locationLatest);
        }
        locationLatestDao.deleteBatchById(covertListStringToInSQL(locationLatests.stream().map(LocationLatest::getUserid).collect(Collectors.toList())));
//        for(LocationLatest l : locationLatests){
//            locationLatestDao.insert(l);
//        }
        locationLatestDao.insertBatch(locationLatests);

        logger.info("一卡通定时器执行了一个任务，用时" + (System.currentTimeMillis() - startTime) / 1000 + "s");
    }

    private Map<String, StudentInfo> getStuMap(Integer size) {
        try {
            return studentInfoService.getStudentMap(size);
        } catch (IOException e) {
            logger.error("无法获取学生信息");
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
