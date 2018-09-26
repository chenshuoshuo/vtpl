package com.you07.eas.service;

import com.you07.eas.dao.DepartmentTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentTypeService {
    @Autowired
    private DepartmentTypeDao departmentTypeDao;
}
