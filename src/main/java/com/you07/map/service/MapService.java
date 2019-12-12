package com.you07.map.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.you07.config.datasource.DataBaseContextHolder;
import com.you07.config.datasource.annotation.DataSourceConnection;
import com.you07.map.dao.MapDao;
import com.you07.map.vo.MapInfoVO;
import com.you07.util.RestTemplateUtil;
import com.you07.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MapService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(MapService.class);

    /**
     * 根据校区名称、大楼名称、房间名称
     * 获取房间的楼层、中心点经纬度
     * 返回格式为：100011,114.002083040278,33.0122075951186
     *
     * @param campusName   校区名称
     * @param buildingName 大楼名称
     * @param roomName     房间名称
     * @return
     */
    @DataSourceConnection(DataBaseContextHolder.DataBaseType.POSTGRESDEFAULT)
    public MapInfoVO queryFloorCenterLngLat(String campusName, String buildingName, String roomName) {
        if(StringUtils.isBlank(campusName))
            throw new NullPointerException("校区名称不能为空");
        if(StringUtils.isBlank(buildingName))
            throw new NullPointerException("建筑名称不能为空");
        StringBuilder uri = new StringBuilder("/map/v2/regeo/code?zoneName=" + campusName);
        if(StringUtils.isNotBlank(roomName))
            uri.append("&roomName=").append(roomName);
        if(StringUtils.isNotBlank(buildingName))
            uri.append("&buildingName=").append(buildingName);
        try {
            JSONObject roomInfo = RestTemplateUtil.getJSONObjectForCmGis(uri.toString());
            logger.debug("从cmgis获取地址:"+roomInfo);
            JSONObject data = Objects.requireNonNull(roomInfo).getJSONObject("data");
            return objectMapper.readValue(data.toJSONString(), MapInfoVO.class);
        }catch (Exception e) {
            e.printStackTrace();
            return new MapInfoVO();
        }
    }

}
