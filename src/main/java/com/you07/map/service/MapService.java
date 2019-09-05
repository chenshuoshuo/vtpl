package com.you07.map.service;

import com.alibaba.fastjson.JSONObject;
import com.you07.config.RestTemplateInterceptor;
import com.you07.config.datasource.DataBaseContextHolder;
import com.you07.config.datasource.annotation.DataSourceConnection;
import com.you07.map.dao.MapDao;
import com.you07.util.RestTemplateUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapService {
    @Autowired
    private MapDao mapDao;

    @Value("")
    private String mapApiUrl;


    /**
     * 根据校区名称、大楼名称、房间名称
     * 获取房间的楼层、中心点经纬度
     * 返回格式为：100011,114.002083040278,33.0122075951186
     * @param campusName 校区名称
     * @param buildingName 大楼名称
     * @param roomName 房间名称
     * @return
     */
    @DataSourceConnection(DataBaseContextHolder.DataBaseType.POSTGRESGIS)
    public String queryFloorCentroLngLat(String campusName, String buildingName, String roomName){
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//            HttpGet get = new HttpGet("https://testgis.you07.com/cmgis-server/map/v2/regeo/code?buildingName="+buildingName+"&roomName="+roomName+"&zoneName="+campusName);
            JSONObject roomInfo = RestTemplateUtil.getJSONObjectForCmGis("https://testgis.you07.com/cmgis-server/map/v2/regeo/code?buildingName="+buildingName+"&roomName="+roomName+"&zoneName="+campusName);
//            CloseableHttpResponse response = httpClient.execute(get);
//            HttpEntity httpEntity = response.getEntity();
//            String roomInfo = EntityUtils.toString(httpEntity);
            System.out.println(roomInfo.toJSONString());
            return roomInfo.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
