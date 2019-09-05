package com.you07.eas.service;

import com.alibaba.fastjson.JSONObject;
import com.you07.eas.dao.AcademyDao;
import com.you07.eas.model.Academy;
import com.you07.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcademyService {
    @Autowired
    private AcademyDao academyDao;
    @Value("${oauth.serverEasUrl}")
    private String getEasurl;

    //请求Url获得资源
    public List<Academy> queryAll(){
        JSONObject jsonObject = null;
        jsonObject = RestTemplateUtil.getJSONObjectForCmGis("getEasurl/os/academy/queryAll");
        List<Academy> academyList = new ArrayList<>();
        int size = jsonObject.size();
        for(int i = 0; i< size; i++) {
            String academyCode = (String) jsonObject.get("academyCode");
            String academyName = (String) jsonObject.get("academyName");
            String orderid = (String) jsonObject.get("orderid");
            String memo = (String) jsonObject.get("memo");
            Academy academy = new Academy();
            academy.setAcadameyCode(academyCode);
            academy.setAcadameyName(academyName);
            academy.setOrderid(orderid);
            academy.setMemo(memo);
            academyList.add(academy);
        }
        return academyList;
    }

    /*@DataSourceConnection(DataBaseContextHolder.DataBaseType.POSTGRESEAS)
    public List<Academy> queryAll(){
        return academyDao.queryAll();
    }*/

    public AcademyDao getAcademyDao() {
        return academyDao;
    }

    public void setAcademyDao(AcademyDao academyDao) {
        this.academyDao = academyDao;
    }
}
