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

    @KafkaListener(topics = {"zos_user_login_queue"})
    public void listen(ConsumerRecord<?, ?> record) throws IOException {
        Optional<?> rawMessage = Optional.ofNullable(record.value());
        if (rawMessage.isPresent()) {
            try {
                Message message = objectMapper.readValue(rawMessage.get().toString(), Message.class);
                logger.info("receive " + rawMessage.get());
                if(StringUtils.isBlank(message.getAPMAC()))
                    throw new RuntimeException("无法获取APMAC");
                HwAp hwAp = hwApDao.selectHwapByMac(message.getAPMAC());
                //设备不存在
                if (hwAp == null) {
                    hwAp = new HwAp(message);
                    hwApDao.insert(hwAp);
                }
                generateLocationLatest(hwAp, message);
            } catch (Exception e) {
                logger.warn( "数据消费失败" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            logger.warn("不合法的返回值：" + rawMessage.get());
        }
    }

    private void generateLocationLatest(HwAp hwAp, Message message) {
        boolean isUpdate = true;
        LocationLatest locationLatest = locationLatestDao.selectByPrimaryKey(message.getUSERID());
        if (locationLatest == null) {
            locationLatest = new LocationLatest();
            isUpdate = false;
        }
        locationLatest.updateByMessage(message);

        locationLatest.setUserid(message.getUSERID());
        if ("学生".equals(message.getUSERGROUPNAME())) {
            StudentInfo studentInfo = studentInfoService.get(message.getUSERID());
            locationLatest.setRealname(studentInfo.getName());
            locationLatest.setGender(studentInfo.getGender());
            locationLatest.setOrgCode(studentInfo.getOrgCode());
            locationLatest.setOrgName(studentInfo.getOrgName());
        } else if ("老师".equals(message.getUSERGROUPNAME())) {
            TeacherInfo teacherInfo = teacherInfoService.get(message.getUSERID());
            locationLatest.setRealname(teacherInfo.getName());
            locationLatest.setGender(teacherInfo.getGender());
            locationLatest.setOrgCode(teacherInfo.getOrgCode());
            locationLatest.setOrgName(teacherInfo.getOrgName());
        } else {
            logger.warn("无法识别的用户组:" + message.getUSERGROUPNAME());
            throw new RuntimeException("无法识别的用户组");
        }

        MapInfoVO mapInfoVO = mapService.queryFloorCenterLngLat(hwAp.getCampus(), hwAp.getBuilding(), hwAp.getRoom());
        if(mapInfoVO.getCenter() == null)
            throw new RuntimeException("无法获取坐标");
        locationLatest.setFloorid(hwAp.getFloorid());
        locationLatest.setLng(mapInfoVO.getCenter().getX());
        locationLatest.setLat(mapInfoVO.getCenter().getY());
        locationLatest.setInSchool(1);
        locationLatest.setInDoor(hwAp.getIndoor());

        if(isUpdate)
            locationLatestDao.updateByPrimaryKey(locationLatest) ;
        else
            locationLatestDao.insertSelective(locationLatest);
    }


}
