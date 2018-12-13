package com.you07.vtpl.schedule;

import com.you07.cas.cityhot.config.CityHotConfig;
import com.you07.cas.cityhot.schedule.DRUDPListenerSchedule;
import com.you07.cas.ruijie.schedule.RuijieUpdateUserInfoSchedule;
import com.you07.cas.ruijie.schedule.RuijieUpdateUserMacSchedule;
import com.you07.cas.shenlan.config.ShenlanCasConfig;
import com.you07.cas.shenlan.schedule.ShenlanUDPListenerSchedule;
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
    @Autowired
    private ShenlanUDPListenerSchedule shenlanUDPListenerSchedule;
    @Autowired
    private ShenlanCasConfig shenlanCasConfig;

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
            case 3:
            {
                System.out.println("start_shenlan_cas");
                shenlanUDPListenerSchedule.setUdpPort(shenlanCasConfig.getUdpPort());
                shenlanUDPListenerSchedule.startJob();
                break;
            }
            default:
                break;
        }
    }
}
