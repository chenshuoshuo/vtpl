package com.you07.map.vo;

/**
 * @author egan
 * @date 2019/9/5 9:55
 * @desc 地图api接口响应实体
 */
public class MapInfoVO {

    private Center center;

    private String zoneId;

    private String level;

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public class Center{
        private Double x;

        private Double y;

        private Double z;

        private Double m;

        public Double getX() {
            return x;
        }

        public void setX(Double x) {
            this.x = x;
        }

        public Double getY() {
            return y;
        }

        public void setY(Double y) {
            this.y = y;
        }

        public Double getZ() {
            return z;
        }

        public void setZ(Double z) {
            this.z = z;
        }

        public Double getM() {
            return m;
        }

        public void setM(Double m) {
            this.m = m;
        }
    }

}
