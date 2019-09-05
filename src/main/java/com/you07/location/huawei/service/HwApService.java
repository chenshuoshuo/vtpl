package com.you07.location.huawei.service;

import com.you07.location.huawei.dao.HwApDao;
import com.you07.location.huawei.model.HwAp;
import com.you07.location.h3cup.dao.H3cUpApDao;
import com.you07.location.h3cup.model.H3cUpAp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HwApService {
    @Autowired
    private HwApDao hwApDao;

    public List<HwAp> selectNewData() {
        return hwApDao.selectNewData();
    }

    public void updataHwAp(Double lng, Double lat, String device_mac, String zoneId) {
        hwApDao.updataHwAp(lng, lat, device_mac, zoneId);
    }
    public HwAp selectHwapByMac(String device_mac){
        return hwApDao.selectHwapByMac(device_mac);
    }

}
