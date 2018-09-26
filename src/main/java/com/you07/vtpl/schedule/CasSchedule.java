package com.you07.vtpl.schedule;

import com.you07.cas.cityhot.config.CityHotConfig;
import com.you07.cas.cityhot.schedule.DRUDPListenerSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("casSchedule")
@EnableAsync
public class CasSchedule {
    @Value("${cas.cas-type}")
    private String casConfigId;
    @Autowired
    private CityHotConfig cityHotConfig;
    @Autowired
    private DRUDPListenerSchedule drudpListenerSchedule;


    @Async
//    @Scheduled(cron = "0 0 */1 * * ?")
    @Scheduled(cron = "0 * * * * ?")
    public void startSchedule(){
        String casConfig[] = casConfigId.split(",");
        for(String configIdStr : casConfig){
            Integer configId = Integer.parseInt(configIdStr);
            switch (configId){
                case 1:
                {
                    drudpListenerSchedule.setUdpPort(cityHotConfig.getUdpPort());
                    drudpListenerSchedule.startJob();
                    break;
                }
                default:
                    break;
            }
        }
    }
}
