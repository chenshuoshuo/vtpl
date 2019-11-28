package com.you07.vtpl.dao;

import com.you07.common.BaseDao;
import com.you07.vtpl.model.LocationCampusInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationCampusInfoDao extends BaseDao<LocationCampusInfo>{

    @Delete({
            "delete from location_campus_info where school_id = #{schoolId}"
    })
    int deleteWithSchoolId(@Param("schoolId") Integer schoolId);

    /**
     * 根据学校ID获取默认校区
     * @param schoolId
     * @return
     */
    @Select({
            "select * from location_campus_info where school_id = #{schoolId} and is_default = 1"
    })
    LocationCampusInfo loadDefaultCampus(@Param("schoolId") Integer schoolId);
}
