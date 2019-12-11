package com.you07.location.joywise;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.you07.eas.model.StudentInfo;
import com.you07.eas.model.TeacherInfo;
import com.you07.eas.service.StudentInfoService;
import com.you07.eas.service.TeacherInfoService;
import com.you07.location.huawei.dao.HwApDao;
import com.you07.location.huawei.model.HwAp;
import com.you07.map.service.MapService;
import com.you07.map.vo.MapInfoVO;
import com.you07.vtpl.dao.LocationLatestDao;
import com.you07.vtpl.model.LocationLatest;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.util.Optional;


/**
 * @author Egan
 * @date 2019/11/4 10:51
 **/
@Component
public class KafkaReceiver {

    private Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);

    @Autowired
    private LocationLatestDao locationLatestDao;

    @Autowired
    private HwApDao hwApDao;

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MapService mapService;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Autowired
    private StudentInfoService studentInfoService;

    public KafkaReceiver() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    @KafkaListener(topics = {"${spring.kafka.topic}"})
    public void listen(ConsumerRecord<?, ?> record) throws IOException {
        Optional<?> rawMessage = Optional.ofNullable(record.value());
        if (rawMessage.isPresent()) {
            try {
                Message message = objectMapper.readValue(rawMessage.get().toString(), Message.class);
                logger.info("receive " + rawMessage.get());
                if (StringUtils.isBlank(message.getAPMAC()))
                    throw new RuntimeException("无法获取APMAC");
                if(StringUtils.isBlank(message.getUSERID())){
                    throw new RuntimeException("无法获取学工号");
                }
                HwAp hwAp = hwApDao.selectHwapByMac(message.getAPMAC());
                //设备不存在
                if (hwAp == null) {
                    hwAp = new HwAp(message);
                    hwApDao.insert(hwAp);
                }
                generateLocationLatest(hwAp, message);
            } catch (Exception e) {
                logger.warn("数据消费失败", e);
                e.printStackTrace();
            }
        } else {
            logger.warn("不合法的返回值：" + rawMessage.get());
        }
    }

    private void generateLocationLatest(HwAp hwAp, Message message) {

        LocationLatest locationLatest = null;

        if ("学生".equals(message.getUSERGROUPNAME())) {
            StudentInfo studentInfo = studentInfoService.get(message.getUSERID());
            if(studentInfo == null || StringUtils.isBlank(studentInfo.getStudentno()))
                throw new RuntimeException("学生不存在");
            locationLatest = new LocationLatest(studentInfo);
        } else if ("老师".equals(message.getUSERGROUPNAME())) {
            TeacherInfo teacherInfo = teacherInfoService.get(message.getUSERID());
            if(teacherInfo == null || StringUtils.isBlank(teacherInfo.getTeachercode()))
                throw new RuntimeException("教职工不存在");
            locationLatest = new LocationLatest(teacherInfo);
        } else {
            throw new RuntimeException("无法识别的用户组:" + message.getUSERGROUPNAME());
        }

        if(hwAp.getLng() == null || hwAp.getLat() == null){
            MapInfoVO mapInfoVO = mapService.queryFloorCenterLngLat(hwAp.getCampus(), hwAp.getBuilding(), hwAp.getRoom());
            if (mapInfoVO.getCenter() == null)
                throw new RuntimeException("无法获取AP设备坐标");
            hwAp.setLng(mapInfoVO.getCenter().getX());
            hwAp.setLat(mapInfoVO.getCenter().getY());
            hwAp.setFloorid(mapInfoVO.getLevel());
            hwApDao.updataHwAp(hwAp.getLng(), hwAp.getLat(), hwAp.getDeviceMac(), hwAp.getZoneId());

        }
        locationLatest.setAccountMac(message.getUSERMAC());
        locationLatest.setZoneId(hwAp.getZoneId());
        locationLatest.setFloorid(hwAp.getFloorid());
        locationLatest.setLng(hwAp.getLng());
        locationLatest.setLat(hwAp.getLat());
        locationLatest.setInSchool(1);
        locationLatest.setInDoor(hwAp.getIndoor());
        locationLatest.setLocationTime(new Date(message.getLOGINTIME()));
        locationLatest.setUsrUpdateTime(new Date(System.currentTimeMillis()));
        locationLatestDao.deleteByPrimaryKey(locationLatest.getUserid());
        locationLatestDao.insertSelective(locationLatest);
    }


}
