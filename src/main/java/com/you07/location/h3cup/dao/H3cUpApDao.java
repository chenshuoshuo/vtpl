package com.you07.location.h3cup.dao;

import com.you07.common.BaseDao;
import com.you07.location.h3cup.model.H3cUpAp;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface H3cUpApDao extends BaseDao<H3cUpAp>{

    /**
     * 获取没有经纬度的AP信息
     * @return
     */
    @Select({
            "select * from location_h3c_up_ap where lng is null"
    })
    List<H3cUpAp> selectNewData();
}
