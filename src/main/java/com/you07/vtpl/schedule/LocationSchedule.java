package com.you07.vtpl.schedule;

import com.you07.location.h3cap.config.H3cApConfig;
import com.you07.location.h3cap.schedule.H3cApLocationSchedule;
import com.you07.location.h3cap.schedule.H3cViewUpdateSchedule;
import com.you07.location.h3cup.config.H3cUpConfig;
import com.you07.location.h3cup.schedule.H3cUpLocationSchedule;
import com.you07.location.ruijie.config.RuijieConfig;
import com.you07.location.ruijie.schedule.RuijieListenerSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("locationSchedule")
@EnableAsync
public class LocationSchedule {
    @Value("${location.location-type}")
    private Integer locationConfigId;

    // 锐捷主动推送定位
    @Autowired
    private RuijieConfig ruijieConfig;
    @Autowired
    private RuijieListenerSchedule ruijieListenerSchedule;

    // 华三泛定位
    @Autowired
    private H3cUpConfig h3cUpConfig;
    @Autowired
    private H3cUpLocationSchedule h3cUpLocationSchedule;

    // 华三AP定位
    @Autowired
    private H3cApConfig h3cApConfig;
    @Autowired
    private H3cViewUpdateSchedule h3cViewUpdateSchedule;
    @Autowired
    private H3cApLocationSchedule h3cApLocationSchedule;

    @Scheduled(cron = "0 * * * * ?")
    public void startSchedule(){
        System.out.println("locationConfigId::"+locationConfigId);
        switch (locationConfigId){
            case 1:
            {
                System.out.println("start ruijie-location");
                ruijieListenerSchedule.setSockePort(ruijieConfig.getScoketPort());
                ruijieListenerSchedule.startJob();
                break;
            }
            case 2:
            {
                System.out.println("start h3c-up-location");
                h3cUpLocationSchedule.setH3cUpConfig(h3cUpConfig);
                h3cUpLocationSchedule.updateH3cUploactionSchedule();
                break;
            }
            case 3 :
            {
                System.out.println("start h3c-ap-location");
                h3cViewUpdateSchedule.setH3cApConfig(h3cApConfig);
                h3cViewUpdateSchedule.updateH3cViewSchedule();

                h3cApLocationSchedule.setH3cApConfig(h3cApConfig);
                h3cApLocationSchedule.updateH3cLocationSchedule();
                break;
            }

            default:
                break;
        }
    }
}
