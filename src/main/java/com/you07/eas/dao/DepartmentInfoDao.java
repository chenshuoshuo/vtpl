package com.you07.eas.dao;

import com.you07.common.BaseDao;
import com.you07.eas.model.DepartmentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentInfoDao extends BaseDao<DepartmentInfo>{

    @Select({
            "select * from eas_zzjg_xsbm where xsbmdm = #{deptCode} limit 1"
    })
    DepartmentInfo loadByDeptCode(@Param("deptCode") String deptCode);
}
