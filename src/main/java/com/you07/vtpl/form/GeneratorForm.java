package com.you07.vtpl.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author egan
 * @date 2019/11/27 13:47
 * @desc
 */
public class GeneratorForm {

    @NotNull
    private Integer size;

    @NotNull
    private Integer campusId;

    @NotBlank
    private String locationTime;

    public String getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(String locationTime) {
        this.locationTime = locationTime;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
