package com.you07.map.service;

import com.you07.config.datasource.DataBaseContextHolder;
import com.you07.config.datasource.annotation.DataSourceConnection;
import com.you07.map.dao.MapDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {
    @Autowired
    private MapDao mapDao;

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
            String roomInfo = mapDao.queryFloorCentroLngLat(campusName, buildingName, roomName);
            return roomInfo;
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }
}
