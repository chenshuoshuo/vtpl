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
    private Double srartLat;
    private Double endLng;
    private Double endLat;

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

    public Double getSrartLat() {
        return srartLat;
    }

    public void setSrartLat(Double srartLat) {
        this.srartLat = srartLat;
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
}
