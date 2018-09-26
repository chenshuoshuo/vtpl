package com.you07.location.ruijie.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "location.ruijie")
public class RuijieConfig {
    private Integer scoketPort;

    public Integer getScoketPort() {
        return scoketPort;
    }

    public void setScoketPort(Integer scoketPort) {
        this.scoketPort = scoketPort;
    }
}
