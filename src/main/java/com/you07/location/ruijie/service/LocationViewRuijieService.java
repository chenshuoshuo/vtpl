package com.you07.location.ruijie.service;

import com.you07.location.ruijie.dao.LocationViewRuijieDao;
import com.you07.location.ruijie.model.LocationViewRuijie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationViewRuijieService {
    @Autowired
    private LocationViewRuijieDao locationViewRuijieDao;

    public List<LocationViewRuijie> listAll(){
        return locationViewRuijieDao.selectAll();
    }
}
