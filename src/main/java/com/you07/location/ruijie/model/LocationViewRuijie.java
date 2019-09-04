package com.you07.location.ruijie.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 锐捷定位位置视图实体
 * @author RY
 * @version 1.0
 * @since 2018-3-14 12:27:07
 *
 */
@Table(name = "location_view_ruijie")
public class LocationViewRuijie{
	/**
	 * 视图ID
	 */
	@Id
	@Column(name = "view_id")
	private Integer viewId;
	/**
	 * 视图名称
	 */
	private String viewName;
	/**
	 * 楼层ID（锐捷）
	 */
	private Integer flooridRuijie;
	/**
	 * 楼层ID（灵奇）
	 */
	private String flooridLq;
	/**
	 * 视图左上角经度
	 */
	private Double leftTopLon;
	/**
	 * 视图左上角纬度
	 */
	private Double leftTopLat;
	/**
	 * 视图右下角经度
	 */
	private Double rightDownLon;
	/**
	 * 视图右下角纬度
	 */
	private Double rightDownLat;
	/**
	 * 大楼编码，对应灵奇微地图大楼polygonid
	 */
	private String buildingCode;
	/**
	 * 室内/室外，1室内，2室外
	 */
	private Integer inDoor;
	/**
	 * 排序
	 */
	private Integer orderid;
	/**
	 * 校区id
	 **/
	private String zoneId;
	/**
	 * 备注
	 */
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

	public Integer getFlooridRuijie() {
		return flooridRuijie;
	}

	public void setFlooridRuijie(Integer flooridRuijie) {
		this.flooridRuijie = flooridRuijie;
	}

	public String getFlooridLq() {
		return flooridLq;
	}

	public void setFlooridLq(String flooridLq) {
		this.flooridLq = flooridLq;
	}

	public Double getLeftTopLon() {
		return leftTopLon;
	}

	public void setLeftTopLon(Double leftTopLon) {
		this.leftTopLon = leftTopLon;
	}

	public Double getLeftTopLat() {
		return leftTopLat;
	}

	public void setLeftTopLat(Double leftTopLat) {
		this.leftTopLat = leftTopLat;
	}

	public Double getRightDownLon() {
		return rightDownLon;
	}

	public void setRightDownLon(Double rightDownLon) {
		this.rightDownLon = rightDownLon;
	}

	public Double getRightDownLat() {
		return rightDownLat;
	}

	public void setRightDownLat(Double rightDownLat) {
		this.rightDownLat = rightDownLat;
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
