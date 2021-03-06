package com.you07.vtpl.form;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author egan
 * @date 2019/11/27 13:47
 * @desc
 */
public class GeneratorForm {

    @ApiModelProperty("生成人数")
    @NotNull
    private Integer size;

    @ApiModelProperty("校区id")
    @NotNull
    private Integer campusId;

    @ApiModelProperty("定位时间，如:2019-01-01 00:00:00")
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
