package com.you07.eas.service;

import com.you07.eas.dao.DepartmentInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentInfoService {
    @Autowired
    private DepartmentInfoDao departmentInfoDao;
}
