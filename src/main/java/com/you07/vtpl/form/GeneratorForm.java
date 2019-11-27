package com.you07.vtpl.form;

import java.util.Date;

/**
 * @author egan
 * @date 2019/11/27 13:47
 * @desc
 */
public class GeneratorForm {

    private Integer size;

    private String campusId;

    private Date locationTime;

    public Date getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(Date locationTime) {
        this.locationTime = locationTime;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
