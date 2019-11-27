package com.you07.vtpl.model;

import com.you07.eas.vo.AcademyVO;
import com.you07.eas.vo.StudentVO;
import com.you07.location.joywise.Message;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户最新位置信息
 * @author RY
 * @since 2018-8-8 15:48:49
 */
@Table(name = "location_latest")
public class LocationLatest {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "userid")
    private String userid;
    /**
     * 姓名
     */
    private String realname;
    /**
     * 上网账号
     */
    private String accountId;
    /**
     * 性别
     */
    private String gender;
    /**
     * 上网账号/MAC
     */
    private String accountMac;
    /**
     * 组织机构代码
     */
    private String orgCode;
    /**
     * 组织机构名称
     */
    private String orgName;
    /**
     * 位置经度
     */
    private Double lng;
    /**
     * 位置纬度
     */
    private Double lat;
    /**
     * 灵奇地图楼层ID
     */
    private String floorid;
    /**
     * 定位时间
     */
    private Date locationTime;
    /**
     * 用户信息更新时间
     */
    private Date usrUpdateTime;
    /**
     * 定位方式，1ap,2接口定位
     */
    private String locationMode;
    /**
     * 室内/室外，1室内，2室外
     */
    private Integer inDoor;
    /**
     * 校内/校外，1校内，2校外
     */
    private Integer inSchool;
    /**
     * 校区ID
     * */
    private String zoneId;

    /**
     * 坐标系类型
     * @return
     */
    private String type;

    public LocationLatest() {
    }

    public void updateByMessage(Message message){
        setRealname(message.getUSERNAME());
        setUserid(message.getUSERID());
        setAccountMac(message.getUSERMAC());
        setLocationMode("1");
        setLocationTime(new Date(message.getLOGINTIME()));
        setUsrUpdateTime(new Date(System.currentTimeMillis()));
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccountMac() {
        return accountMac;
    }

    public void setAccountMac(String accountMac) {
        this.accountMac = accountMac;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getFloorid() {
        return floorid;
    }

    public void setFloorid(String floorid) {
        this.floorid = floorid;
    }

    public Date getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(Date locationTime) {
        this.locationTime = locationTime;
    }

    public Date getUsrUpdateTime() {
        return usrUpdateTime;
    }

    public void setUsrUpdateTime(Date usrUpdateTime) {
        this.usrUpdateTime = usrUpdateTime;
    }

    public String getLocationMode() {
        return locationMode;
    }

    public void setLocationMode(String locationMode) {
        this.locationMode = locationMode;
    }

    public Integer getInDoor() {
        return inDoor;
    }

    public void setInDoor(Integer inDoor) {
        this.inDoor = inDoor;
    }

    public Integer getInSchool() {
        return inSchool;
    }

    public void setInSchool(Integer inSchool) {
        this.inSchool = inSchool;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStudent(StudentVO studentVO) {
        setRealname(studentVO.getRealName());
    }

    public void setOrgs(AcademyVO academyVO) {
        setOrgName(academyVO.getAcademyName());
        setOrgCode(academyVO.getAcademyCode());
    }
}
