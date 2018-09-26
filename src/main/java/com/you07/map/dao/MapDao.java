package com.you07.map.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MapDao {
    @Select({
          "select replace(replace(substr(mp.polygonid, 0, 7) || point(st_centroid(mp.geom)),'(',','), ')', '')",
            "from map_polygon mp, map_polygon mp1, map_zone mz ",
            "where mp.name = #{roomName} and mp.parent_polygonid = mp1.polygonid",
            "and mp1.name = #{buildingName} and substr(mp.polygonid, 0, 5) = mz.zoneid",
            "and mz.name = #{campusName};"
    })
    String queryFloorCentroLngLat(@Param("campusName") String campusName,
                                  @Param("buildingName") String buildingName,
                                  @Param("roomName") String roomName);
}
