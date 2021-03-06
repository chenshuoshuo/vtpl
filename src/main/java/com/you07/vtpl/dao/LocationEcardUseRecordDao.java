package com.you07.vtpl.dao;

import com.you07.common.BaseDao;
import com.you07.vtpl.model.LocationEcardUseRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author egan
 * @date 2019/11/29 10:55
 * @desc
 */
@Repository
public interface LocationEcardUseRecordDao extends BaseDao<LocationEcardUseRecord> {

    @Select("select distinct on (user_code) * from (select * from location_ecard_use_record order by use_time  ) t limit #{n}")
    List<LocationEcardUseRecord> selectEcardList(@Param("n") Integer number);

    @Delete("delete from location_ecard_use_record where record_code in (${ids}) ")
    int deleteBatchById(@Param("ids") String ids);

}
