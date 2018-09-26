package com.you07.vtpl.service;

import com.you07.vtpl.dao.LocationCampusInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationCampusInfoService {
    @Autowired
    private LocationCampusInfoDao locationCampusInfoDao;

    public int deleteWithSchoolId(Integer schoolId){
        return locationCampusInfoDao.deleteWithSchoolId(schoolId);
    }

}
