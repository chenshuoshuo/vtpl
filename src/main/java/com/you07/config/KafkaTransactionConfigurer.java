//package com.you07.config;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.listener.KafkaMessageListenerContainer;
//import org.springframework.kafka.listener.MessageListener;
//import org.springframework.kafka.listener.config.ContainerProperties;
//
//import java.util.logging.Logger;
//
//
///**
// * @author egan
// * @date 2019/11/12 16:05
// * @desc
// */
//@Configuration
//public class KafkaTransactionConfigurer {
//
//    @Bean
//    public KafkaMessageListenerContainer container() {
//        ContainerProperties properties = new ContainerProperties("topic.quick.bean");
//
//        properties.setGroupId("bean");
//
//        properties.setMessageListener(new MessageListener<Integer,String>() {
//            private Logger log = LoggerFactory.getLogger(this.getClass());
//            @Override
//            public void onMessage(ConsumerRecord<Integer, String> record) {
//                log.info("topic.quick.bean receive : " + record.toString());
//            }
//        });
//
//        return new KafkaMessageListenerContainer(consumerFactory(), properties);
//    }
//
//}
