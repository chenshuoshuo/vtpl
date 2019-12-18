package com.you07.eas.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.you07.eas.model.TeacherInfo;
import com.you07.eas.vo.OrgVO;
import com.you07.eas.vo.StudentVO;
import com.you07.eas.vo.TeacherVO;
import com.you07.util.RestTemplateUtil;
import com.you07.util.StringUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TeacherInfoService {

    public List<TeacherInfo> listAll() {
        return null;
    }

    public TeacherInfo get(String teacherCode) {
        JSONObject jsonObject = RestTemplateUtil.getJSONObjectForCmIps("/os/teachingStaff/get/" + teacherCode);
        TeacherVO teacherVO = jsonObject.getObject("data", TeacherVO.class);
        //根据机构编号得到机构名
        JSONObject jsonObject1 = RestTemplateUtil.getJSONObjectForCmIps("/os/organization/get/" + teacherVO.getOrganizationCode());
        OrgVO orgVO = jsonObject1.getObject("data", OrgVO.class);
        return new TeacherInfo(teacherVO, orgVO);
    }

    public List<TeacherVO> getTeacherList(Integer size) throws IOException {
        String json = RestTemplateUtil.getJSONObjectForCmIps("/os/teachingStaff/queryAll").getJSONArray("data").toJSONString();
        return JSONArray.parseArray(json, TeacherVO.class);
    }

    public List<OrgVO> getOrgVO(){
        return RestTemplateUtil.getJSONObjectForCmIps("/os/organization/queryAll").getJSONArray("data").toJavaList(OrgVO.class);
    }


    public Map<String, TeacherInfo> generateMap(Integer size) throws IOException {
        Map<String,OrgVO> orgVOMap = getOrgVO().stream().collect(Collectors.toMap(OrgVO::getOrganizationCode, o->o));
        List<TeacherVO> teacherVOS = getTeacherList(size);

        return teacherVOS.stream().filter(t-> StringUtil.isNotEmpty(t.getOrganizationCode())).collect(Collectors.toMap(TeacherVO::getStaffNumber, t->new TeacherInfo(t, orgVOMap.get(t.getOrganizationCode()))));
    }
}
