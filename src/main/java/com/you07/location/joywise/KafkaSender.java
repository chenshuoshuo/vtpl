package com.you07.location.joywise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Egan
 * @date 2019/11/4 10:57
 **/

@Component
public class KafkaSender {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private Logger logger = LoggerFactory.getLogger(KafkaSender.class);

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setUSERID(String.valueOf(System.currentTimeMillis()));
        message.setUSERIP("123.123.123.123");
        try {
            String json = objectMapper.writeValueAsString(message);
            logger.info("send" + json);
            kafkaTemplate.send("zos_user_login_queue", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
