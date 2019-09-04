package com.you07.location.huawei.dao;

import com.you07.location.huawei.model.HwAp;
import com.you07.common.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HwApDao extends BaseDao<HwAp> {

    /**
     * 获取没有经纬度的AP信息
     *
     * @return
     */
    @Select({
            "select * from hw_device_location where lng is null"
    })
    List<HwAp> selectNewData();

    /**
     * 根据mac地址更新经纬度
     *
     * @param lng
     * @param lat
     * @param device_mac
     */
    @Update({"update hw_device_location set lng=#{lng},lat=#{lat},zone_id=#{zid} where device_mac=#{device_mac}"})
    void updataHwAp(@Param("lng") Double lng, @Param("lat") Double lat, @Param("device_mac") String device_mac, @Param("zid") String zoneId);

    @Select({
            "select * from hw_device_location where device_mac=#{device_mac}"
    })
    HwAp selectHwapByMac(@Param("device_mac") String device_mac);
}
