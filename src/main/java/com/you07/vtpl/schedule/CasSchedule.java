package com.you07.vtpl.schedule;

import com.you07.cas.cityhot.config.CityHotConfig;
import com.you07.cas.cityhot.schedule.DRUDPListenerSchedule;
import com.you07.cas.ruijie.schedule.RuijieUpdateUserInfoSchedule;
import com.you07.cas.ruijie.schedule.RuijieUpdateUserMacSchedule;
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
    private Integer casConfigId;
    @Autowired
    private CityHotConfig cityHotConfig;
    @Autowired
    private DRUDPListenerSchedule drudpListenerSchedule;
    @Autowired
    private RuijieUpdateUserInfoSchedule ruijieUpdateUserInfoSchedule;
    @Autowired
    private RuijieUpdateUserMacSchedule ruijieUpdateUserMacSchedule;

    @Async
    @Scheduled(cron = "0 * * * * ?")
    public void startSchedule(){
        System.out.println("casConfigId:"+casConfigId);
        switch (casConfigId){
            case 1:
            {
                drudpListenerSchedule.setUdpPort(cityHotConfig.getUdpPort());
                drudpListenerSchedule.startJob();
                break;
            }
            case 2:
            {
                System.out.println("start_ruijie_cas");
//                ruijieUpdateUserInfoSchedule.startJob();
                ruijieUpdateUserMacSchedule.startJob();
                break;
            }
            default:
                break;
        }
    }
}
