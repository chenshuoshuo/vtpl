package com.you07.eas.service;

import com.you07.eas.dao.MajorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorService {
    @Autowired
    private MajorDao majorDao;

    public MajorDao getMajorDao() {
        return majorDao;
    }

    public void setMajorDao(MajorDao majorDao) {
        this.majorDao = majorDao;
    }
}
