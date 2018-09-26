package com.you07.eas.service;

import com.you07.eas.dao.ClassInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassInfoService {
    @Autowired
    private ClassInfoDao classInfoDao;

    public ClassInfoDao getClassInfoDao() {
        return classInfoDao;
    }

    public void setClassInfoDao(ClassInfoDao classInfoDao) {
        this.classInfoDao = classInfoDao;
    }
}
