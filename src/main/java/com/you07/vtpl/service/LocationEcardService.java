package com.you07.vtpl.service;

import com.you07.eas.model.StudentInfo;
import com.you07.eas.model.TeacherInfo;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * egan
     * 将一卡通使用记录转换成最后点位保存在latest_location表中
     *
     * @param
     * @date 2019/11/29 11:05
     **/
    @Transactional
    public synchronized void saveEcardRecord() {
        //每次限制存一万条
        List<LocationEcardUseRecord> records = locationEcardUseRecordDao.selectEcardList(10000);
        //如果有数据，转换成location_latest
        while(records.size()>0){
            List<LocationLatest> locationLatests = new ArrayList<>();
            for (LocationEcardUseRecord r : records) {
                LocationEcardDevice device = locationEcardDeviceDao.selectByPrimaryKey(r.getDeviceCode());
                LocationLatest locationLatest = new LocationLatest();
                if (device == null) {
                    device = new LocationEcardDevice();
                    device.setDeviceCode(r.getDeviceCode());
                    device.setDeviceName("未识别设备");
                }
                if (device.getDeviceLat() == null || device.getDeviceLng() == null || device.getGisLeaf() == null) {
                    MapInfoVO mapInfoVO = mapService.queryFloorCenterLngLat(device.getInstallCampus(), device.getInstallBuilding(), device.getInstallRoom());
                    try {
                        locationLatest.setZoneId(mapInfoVO.getZoneId());
                        //如果无法获取到经纬度，跳过该记录
                        device.setDeviceLat(mapInfoVO.getCenter().getX());
                        device.setDeviceLng(mapInfoVO.getCenter().getX());
                        device.setGisLeaf(Integer.parseInt(mapInfoVO.getLevel()));
                        locationEcardDeviceDao.updateByPrimaryKey(device);
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }

                locationLatest.setUserid(r.getUserCode());
                try {
                    //如果无法获取到学工信息，跳过该记录
                    StudentInfo studentInfo = studentInfoService.get(r.getUserCode());
                    if (studentInfo != null && studentInfo.getStudentno() == null) {
                        locationLatest.setDataByStudentInfo(studentInfo);
                    } else {
                        TeacherInfo teacherInfo = teacherInfoService.get(r.getUserCode());
                        locationLatest.setDataByTeacherInfo(teacherInfo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                locationLatest.setInSchool(1);
                locationLatest.setLng(device.getDeviceLng());
                locationLatest.setLat(device.getDeviceLat());
                locationLatest.setFloorid(String.valueOf(device.getGisLeaf()));
                locationLatest.setUsrUpdateTime(new Date(System.currentTimeMillis()));
                locationLatestDao.deleteByPrimaryKey(locationLatest.getUserid());
                locationLatests.add(locationLatest);
            }
            locationLatestDao.insertBatch(locationLatests);
            records = locationEcardUseRecordDao.selectEcardList(10000);
        }

    }
}
