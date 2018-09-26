package com.you07.location.h3cup.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 华三泛定位AP信息
 * @author RY
 * @since 2018-9-4 09:33:58
 * @version 1.0
 */
@Table(name = "location_h3c_up_ap")
public class H3cUpAp {
    @Id
    /**
     * AP代码
     */
    private String apCode;
    /**
     * 校区名称
     */
    private String campusName;
    /**
     * 大楼名称
     */
    private String buildingName;
    /**
     * 房间名称
     */
    private String roomName;
    /**
     * 楼层ID
     */
    private String floorId;
    /**
     * 室内/室外，1室内，2室外
     */
    private Integer inDoor;
    /**
     * AP经度
     */
    private Double lng;
    /**
     * AP纬度
     */
    private Double lat;
    /**
     * 排序
     */
    private Integer orderid;
    /**
     * 备注
     */
    private String memo;

    public String getApCode() {
        return apCode;
    }

    public void setApCode(String apCode) {
        this.apCode = apCode;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public Integer getInDoor() {
        return inDoor;
    }

    public void setInDoor(Integer inDoor) {
        this.inDoor = inDoor;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
