package com.you07.vtpl.model;


import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

public class LocationEcardUseRecord {

  @Id
  private String recordCode;
  private String deviceCode;
  private String ecardNo;
  private String userCode;
  private Date useTime;


  public String getRecordCode() {
    return recordCode;
  }

  public void setRecordCode(String recordCode) {
    this.recordCode = recordCode;
  }


  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }


  public String getEcardNo() {
    return ecardNo;
  }

  public void setEcardNo(String ecardNo) {
    this.ecardNo = ecardNo;
  }


  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }


  public Date getUseTime() {
    return useTime;
  }

  public void setUseTime(Timestamp useTime) {
    this.useTime = useTime;
  }

}
