package com.you07.location.joywise;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.you07.vtpl.dao.LocationLatestDao;
import com.you07.vtpl.model.LocationLatest;
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
    private ObjectMapper objectMapper;

    @KafkaListener(topics = {"zos_user_login_queue"})
    public void listen(ConsumerRecord<?,?> record) throws IOException {
        Optional<?> rawMessage = Optional.ofNullable(record.value());

        if(rawMessage.isPresent()){
            logger.info("receive " + rawMessage.get());
            locationLatestDao.insert(new LocationLatest(objectMapper.readValue(((String) rawMessage.get()).getBytes(), Message.class)));
        }
    }

}
