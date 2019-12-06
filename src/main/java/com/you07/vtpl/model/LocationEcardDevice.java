package com.you07.vtpl.model;


import javax.persistence.Id;

public class LocationEcardDevice {

  @Id
  private String deviceCode;
  private String deviceName;
  private String installCampus;
  private String installBuilding;
  private String installRoom;
  private Double deviceLng;
  private Double deviceLat;
  private Integer gisLeaf;
  private Integer orderId;
  private String deviceStatus;
  private String memo;

  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }


  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getInstallCampus() {
    return installCampus;
  }

  public void setInstallCampus(String installCampus) {
    this.installCampus = installCampus;
  }

  public String getInstallBuilding() {
    return installBuilding;
  }

  public void setInstallBuilding(String installBuilding) {
    this.installBuilding = installBuilding;
  }


  public String getInstallRoom() {
    return installRoom;
  }

  public void setInstallRoom(String installRoom) {
    this.installRoom = installRoom;
  }


  public Double getDeviceLng() {
    return deviceLng;
  }

  public void setDeviceLng(Double deviceLng) {
    this.deviceLng = deviceLng;
  }


  public Double getDeviceLat() {
    return deviceLat;
  }

  public void setDeviceLat(Double deviceLat) {
    this.deviceLat = deviceLat;
  }


  public Integer getGisLeaf() {
    return gisLeaf;
  }

  public void setGisLeaf(Integer gisLeaf) {
    this.gisLeaf = gisLeaf;
  }


  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public String getDeviceStatus() {
    return deviceStatus;
  }

  public void setDeviceStatus(String deviceStatus) {
    this.deviceStatus = deviceStatus;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

}
