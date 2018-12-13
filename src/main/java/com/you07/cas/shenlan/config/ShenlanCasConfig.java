package com.you07.cas.shenlan.config;


import com.you07.cas.shenlan.schedule.ShenlanUDPListenerSchedule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cas.shenlan")
public class ShenlanCasConfig {
    private Integer udpPort;

    public Integer getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(Integer udpPort) {
        this.udpPort = udpPort;
    }

//    @Bean(destroyMethod = "close")
//    public ShenlanUDPListenerSchedule schedule(){
//        return new ShenlanUDPListenerSchedule(udpPort);
//    }
}