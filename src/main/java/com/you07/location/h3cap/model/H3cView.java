package com.you07.location.h3cap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 华三定位位置视图实体
 * @author RY
 * @version 1.0
 * @since 2018-9-26 19:04:13
 *
 */
@Entity
@Table(name = "location_h3c_view")
public class H3cView implements java.io.Serializable{
	/**
	 * 视图ID
	 */
	@Id
	@Column(name = "view_id", unique = true, nullable = false)
	private Integer viewId;
	/**
	 * 视图名称
	 */
	@Column(name = "view_name", unique = true, nullable = false)
	private String viewName;
	/**
	 * 视图原点经度
	 */
	@Column(name = "lon")
	private Double lon;
	/**
	 * 视图原点纬度
	 */
	@Column(name = "lat")
	private Double lat;
	/**
	 * 视图级别
	 */
	@Column(name = "level")
	private Integer level;
	/**
	 * 下级视图个数
	 */
	@Column(name = "sub_location_count")
	private Integer subLocationCount;
	/**
	 * 视图比例尺，每100像素代表的距离
	 */
	@Column(name = "scale")
	private Double scale;
	/**
	 * 比例尺类型，0米，1英尺
	 */
	@Column(name = "scale_type")
	private Integer scaleType;
	/**
	 * 楼层ID，对应GIS微地图楼层ID
	 */
	@Column(name = "floorid")
	private String floorid;
	/**
	 * 大楼编码，对应GIS微地图大楼polygonid
	 */
	@Column(name = "building_code")
	private String buildingCode;
	/**
	 * 室内/室外，1室内，2室外
	 */
	@Column(name = "in_door")
	private Integer inDoor;
	/**
	 * 排序
	 */
	@Column(name = "orderid")
	private Integer orderid;
	/**
	 * 校区Id
	 **/
	private String zoneId;
	/**
	 * 备注
	 */
	@Column(name = "memo")
	private String memo;

	public Integer getViewId() {
		return viewId;
	}

	public void setViewId(Integer viewId) {
		this.viewId = viewId;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSubLocationCount() {
		return subLocationCount;
	}

	public void setSubLocationCount(Integer subLocationCount) {
		this.subLocationCount = subLocationCount;
	}

	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	public Integer getScaleType() {
		return scaleType;
	}

	public void setScaleType(Integer scaleType) {
		this.scaleType = scaleType;
	}

	public String getFloorid() {
		return floorid;
	}

	public void setFloorid(String floorid) {
		this.floorid = floorid;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public Integer getInDoor() {
		return inDoor;
	}

	public void setInDoor(Integer inDoor) {
		this.inDoor = inDoor;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
