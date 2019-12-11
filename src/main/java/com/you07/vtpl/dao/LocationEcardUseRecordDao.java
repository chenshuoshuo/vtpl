package com.you07.vtpl.dao;

import com.you07.common.BaseDao;
import com.you07.vtpl.model.LocationEcardUseRecord;
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

    @Select("select * from location_ecard_use_record group by user_code,record_code limit #{n}")
    List<LocationEcardUseRecord> selectEcardList(@Param("n") Integer number);

}
