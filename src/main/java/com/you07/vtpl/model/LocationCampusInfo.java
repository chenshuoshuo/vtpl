package com.you07.vtpl.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 校区信息
 * @author RY
 * @since 2018-8-8 17:04:37
 */

@Table(name = "location_campus_info")
public class LocationCampusInfo {
    /**
     * 校区ID
     */
    @Id
    @Column(name = "campus_id")
    private Integer campusId;
    /**
     * 学校ID
     */
    private Integer schoolId;
    /**
     * 校区名称
     */
    private String campusName;
    /**
     * 校区LOGO
     */
    private String campusLogo;
    /**
     * 左下经度
     */
    private Double leftDownLng;
    /**
     * 左下纬度
     */
    private Double leftDownLat;
    /**
     * 右上经度
     */
    private Double rightTopLng;
    /**
     * 右上纬度
     */
    private Double rightTopLat;
    /**
     * 是否默认，1是，0否
     */
    private Integer isDefault;
    /**
     * 排序
     */
    private Integer orderid;
    /**
     * 备注
     */
    private String memo;
}
