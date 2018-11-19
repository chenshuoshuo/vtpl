package com.you07.eas.service;

import com.you07.config.datasource.DataBaseContextHolder;
import com.you07.config.datasource.annotation.DataSourceConnection;
import com.you07.eas.dao.StudentInfoDao;
import com.you07.eas.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {
    @Autowired
    private StudentInfoDao studentInfoDao;

    @DataSourceConnection(DataBaseContextHolder.DataBaseType.POSTGRESEAS)
    public List<StudentInfo> listAll(){
        return studentInfoDao.listAll();
    }

    @DataSourceConnection(DataBaseContextHolder.DataBaseType.POSTGRESEAS)
    public StudentInfo get(String studentNo){
        return studentInfoDao.loadByStudentNo(studentNo);
    }

    @DataSourceConnection(DataBaseContextHolder.DataBaseType.POSTGRESEAS)
    public List<StudentInfo> getInSchool(Integer schoolYear){
        return studentInfoDao.getInSchool(schoolYear);
    }
}
