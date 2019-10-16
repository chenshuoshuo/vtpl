package com.you07.vtpl.model;

/**
 * @ClassName Gps
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/10/16 11:09
 * @Version V1.0
 **/
public class Gps {
    private Double lon;
    private Double lat;
    public Gps(){}
    public Gps(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
