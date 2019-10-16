package com.you07.vtpl.model;

/**
 * @ClassName RemovalLocation
 * @Description TODO
 * @Author Wells
 * @Date 2019/7/11 20:03
 * @Version 1.0
 **/
public class RemovalLocation {
    private String userid;
    private Double startLng;
    private Double startLat;
    private Double endLng;
    private Double endLat;
    /**
     * 坐标系类型
     * @return
     */
    private String type;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Double getStartLng() {
        return startLng;
    }

    public void setStartLng(Double startLng) {
        this.startLng = startLng;
    }


    public Double getEndLng() {
        return endLng;
    }

    public void setEndLng(Double endLng) {
        this.endLng = endLng;
    }

    public Double getEndLat() {
        return endLat;
    }

    public void setEndLat(Double endLat) {
        this.endLat = endLat;
    }

    public Double getStartLat() {
        return startLat;
    }

    public void setStartLat(Double startLat) {
        this.startLat = startLat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
