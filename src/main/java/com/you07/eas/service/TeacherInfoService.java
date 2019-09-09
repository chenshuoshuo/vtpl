package com.you07.eas.service;

import com.alibaba.fastjson.JSONObject;
import com.you07.config.datasource.DataBaseContextHolder;
import com.you07.config.datasource.annotation.DataSourceConnection;
import com.you07.eas.dao.TeacherInfoDao;
import com.you07.eas.model.StudentInfo;
import com.you07.eas.model.TeacherInfo;
import com.you07.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherInfoService {

    public List<TeacherInfo> listAll(){
        return null;
    }

    public TeacherInfo get(String teacherCode){
        JSONObject jsonObject = null;
        jsonObject = RestTemplateUtil.getJSONObjectForCmIps("/os/teachingStaff/get/"+teacherCode);
        TeacherInfo teacherInfo = new TeacherInfo();
        String name = jsonObject.getJSONObject("data").getString("realName");
        String gender = jsonObject.getJSONObject("data").getString("gender");
        String organizationCode = jsonObject.getJSONObject("data").getString("organizationCode");
        //根据机构编号得到机构名
        JSONObject jsonObject1 = null;
        jsonObject1 = RestTemplateUtil.getJSONObjectForCmIps("/os/organization/get/"+organizationCode);
        String organizationName = jsonObject1.getJSONObject("data").getString("organizationName");
        teacherInfo.setGender(gender);
        teacherInfo.setName(name);
        teacherInfo.setOrgCode(organizationCode);
        teacherInfo.setOrgName(organizationName);
        return teacherInfo;
    }
}
