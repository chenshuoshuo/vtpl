package com.you07.eas.service;

import com.alibaba.fastjson.JSONObject;
import com.you07.config.datasource.DataBaseContextHolder;
import com.you07.config.datasource.annotation.DataSourceConnection;
import com.you07.eas.dao.StudentInfoDao;
import com.you07.eas.model.Academy;
import com.you07.eas.model.StudentInfo;
import com.you07.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentInfoService {
    @Autowired
    private StudentInfoDao studentInfoDao;
    @Value("${oauth.serverEasUrl}")
    private String getEasurl;

    public StudentInfo get(String studentNo){
        JSONObject jsonObject = null;
        jsonObject = RestTemplateUtil.getJSONObjectForCmGis(getEasurl+"/os/studentInfo/get/"+studentNo);
        StudentInfo studentInfo = new StudentInfo();
        String name = jsonObject.getJSONObject("data").getString("realName");
        String gender = jsonObject.getJSONObject("data").getString("gender");
        String classCode = jsonObject.getJSONObject("data").getString("classCode");
        //根据学号编号得到班级编号
        JSONObject jsonObject1 = null;
        jsonObject1 = RestTemplateUtil.getJSONObjectForCmGis(getEasurl+"/os/classInfo/get/"+classCode);
        String majorCode = jsonObject1.getJSONObject("data").getString("majorCode");
        //根据专业编号得到院系编号
        JSONObject jsonObject2 = null;
        jsonObject2 = RestTemplateUtil.getJSONObjectForCmGis(getEasurl+"/os/major/get/"+majorCode);
        String academyCode = jsonObject2.getJSONObject("data").getString("academyCode");
        //根据院系编号得到院系名
        JSONObject jsonObject3 = null;
        jsonObject3 = RestTemplateUtil.getJSONObjectForCmGis(getEasurl+"/os/academy/get/"+academyCode);
        String academyName = jsonObject3.getJSONObject("data").getString("academyName");
        studentInfo.setGender(gender);
        studentInfo.setName(name);
        studentInfo.setOrgCode(academyCode);
        studentInfo.setOrgName(academyName);
        return studentInfo;
    }

    @DataSourceConnection(DataBaseContextHolder.DataBaseType.POSTGRESEAS)
    public List<StudentInfo> getInSchool(Integer schoolYear){
        return studentInfoDao.getInSchool(schoolYear);
    }
}
