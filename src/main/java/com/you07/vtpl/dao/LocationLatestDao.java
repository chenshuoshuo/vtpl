package com.you07.vtpl.dao;

import com.you07.common.BaseDao;
import com.you07.vtpl.model.LocationLatest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationLatestDao extends BaseDao<LocationLatest>{
    /**
     * 根据上网账号/MAC
     * 注销绑定的信息
     * @param accountMac
     * @return
     */
    @Update({
            "update location_latest set account_mac = null where account_mac = #{accountMac}",
            "and userid != #{userid}"
    })
    int invalidMac(@Param("accountMac") String accountMac,
                   @Param("userid") String userid);

    /**
     * 根据上网账号/MAC获取信息
     * @param accountMac
     * @return
     */
    @Select({
            "select * from location_latest where account_mac = #{accountMac} limit 1"
    })
    LocationLatest loadByAccountMac(@Param("accountMac") String accountMac);

    /**
     *根据MAC地址
     * 注销所有用户该MAC
     * @param mac
     */
    @Update({
            "update location_latest set account_mac = null where account_mac = #{mac} "
    })
    void updateByMac(@Param("mac") String mac);

    /**
     * 根据上网账号accountId获取信息
     * @param accountId
     * @return
     */
    @Select({
            "select * from location_latest where account_id = #{accountId} limit 1"
    })
    LocationLatest selectByAccountId(@Param("accountId") String accountId);

    /**
     * 根据上网账号/MAC
     * 注销绑定的信息
     * @param accountId
     * @param userid
     * @return
     */
    @Update({
            "update location_latest set account_id = null where account_id = #{accountId}",
            "and userid != #{userid}"
    })
    int invalidAccountId(@Param("accountId") String accountId,
                   @Param("userid") String userid);

    @Delete("delete from location_latest where account_mac = 'vtpl-test-data' ")
    void clearTestData();

    @Delete("delete from location_history_year where account_mac = 'vtpl-test-data' ")
    void clearTestYearData();

    @Delete("delete from location_history_month where account_mac = 'vtpl-test-data' ")
    void clearTestMonthData();

    @Delete("delete from location_history_day where account_mac = 'vtpl-test-data' ")
    void clearTestDayData();
}
