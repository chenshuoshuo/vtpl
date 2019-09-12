package com.you07.eas.service;

import com.alibaba.fastjson.JSONObject;
import com.you07.config.datasource.DataBaseContextHolder;
import com.you07.config.datasource.annotation.DataSourceConnection;
import com.you07.eas.model.Academy;
import com.you07.eas.model.Result;
import com.you07.eas.model.StudentInfo;
import com.you07.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentInfoService {
    public StudentInfo get(String studentNo){
        JSONObject jsonObject = null;
        jsonObject = RestTemplateUtil.getJSONObjectForCmIps("/os/studentInfo/get/"+studentNo);
        StudentInfo studentInfo = new StudentInfo();
        String name = jsonObject.getJSONObject("data").getString("realName");
        String gender = jsonObject.getJSONObject("data").getString("gender");
        String classCode = jsonObject.getJSONObject("data").getString("classCode");
        //根据学号编号得到班级编号
        JSONObject jsonObject1 = null;
        jsonObject1 = RestTemplateUtil.getJSONObjectForCmIps("/os/classInfo/get/"+classCode);
        String majorCode = jsonObject1.getJSONObject("data").getString("majorCode");
        //根据专业编号得到院系编号
        JSONObject jsonObject2 = null;
        jsonObject2 = RestTemplateUtil.getJSONObjectForCmIps("/os/major/get/"+majorCode);
        String academyCode = jsonObject2.getJSONObject("data").getString("academyCode");
        //根据院系编号得到院系名
        JSONObject jsonObject3 = null;
        jsonObject3 = RestTemplateUtil.getJSONObjectForCmIps("/os/academy/get/"+academyCode);
        String academyName = jsonObject3.getJSONObject("data").getString("academyName");
        studentInfo.setGender(gender);
        studentInfo.setName(name);
        studentInfo.setOrgCode(academyCode);
        studentInfo.setOrgName(academyName);
        return studentInfo;
    }

    public List<StudentInfo> getInSchool(Integer schoolYear){
        JSONObject jsonObject = null;
        jsonObject = RestTemplateUtil.getJSONObjectForCmIps("/os/studentInfo/queryAll");
        List<StudentInfo> studentInfoList = new ArrayList<>();
        Result<List<StudentInfo>> listResult = jsonObject.toJavaObject(Result.class);
        List<StudentInfo> studentInfoList1 = listResult.getData();
        for (int i = 0; i < studentInfoList1.size(); i++) {
            StudentInfo studentInfo1 = new StudentInfo();
            Map<String, Object> map = new LinkedHashMap<>();
            map = (Map<String, Object>) studentInfoList1.get(i);
            studentInfo1.setName((String) map.get("realName"));
            studentInfo1.setGender((String) map.get("gender"));
            String classCode = (String) map.get("classCode");
            //根据班级号查询机构
            //根据学号编号得到班级编号
            JSONObject jsonObject1 = null;
            jsonObject1 = RestTemplateUtil.getJSONObjectForCmIps("/os/classInfo/get/" + classCode);
            String majorCode = jsonObject1.getJSONObject("data").getString("majorCode");
            //根据专业编号得到院系编号
            JSONObject jsonObject2 = null;
            jsonObject2 = RestTemplateUtil.getJSONObjectForCmIps("/os/major/get/" + majorCode);
            String academyCode = jsonObject2.getJSONObject("data").getString("academyCode");
            //根据院系编号得到院系名
            JSONObject jsonObject3 = null;
            jsonObject3 = RestTemplateUtil.getJSONObjectForCmIps("/os/academy/get/" + academyCode);
            String academyName = jsonObject3.getJSONObject("data").getString("academyName");
            studentInfo1.setOrgCode(academyCode);
            studentInfo1.setOrgName(academyName);
            studentInfoList.add(studentInfo1);
        }
        return studentInfoList;
    }
}
