
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for onlineUserInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="onlineUserInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessType" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gateway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipv6Gateway" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipv6Num" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="nasCommunity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasIpv6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nasType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasTypeNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="netMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="onlineTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timesegmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv6LocalLink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userTemplateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userVlan" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="usergroupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wpNasIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wpNasPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="operatorsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorsUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "onlineUserInfo", propOrder = {
    "accessType",
    "accountId",
    "apMac",
    "areaName",
    "dns",
    "gateway",
    "ipv6Gateway",
    "ipv6Num",
    "nasCommunity",
    "nasIp",
    "nasIpv6",
    "nasLocation",
    "nasName",
    "nasPort",
    "nasType",
    "nasTypeNum",
    "netMask",
    "onlineTime",
    "packageName",
    "policyId",
    "serviceId",
    "serviceSuffix",
    "ssid",
    "suVersion",
    "timesegmentId",
    "userId",
    "userIpv4",
    "userIpv6",
    "userIpv6LocalLink",
    "userMac",
    "userName",
    "userTemplateId",
    "userVlan",
    "usergroupId",
    "wpNasIp",
    "wpNasPort",
    "operatorsName",
    "operatorsUserId"
})
public class OnlineUserInfo {

    protected Short accessType;
    protected String accountId;
    protected String apMac;
    protected String areaName;
    protected String dns;
    protected String gateway;
    protected String ipv6Gateway;
    protected Short ipv6Num;
    protected String nasCommunity;
    protected String nasIp;
    protected String nasIpv6;
    protected String nasLocation;
    protected String nasName;
    protected Long nasPort;
    protected String nasType;
    protected String nasTypeNum;
    protected String netMask;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar onlineTime;
    protected String packageName;
    protected String policyId;
    protected String serviceId;
    protected String serviceSuffix;
    protected String ssid;
    protected String suVersion;
    protected String timesegmentId;
    protected String userId;
    protected String userIpv4;
    protected String userIpv6;
    protected String userIpv6LocalLink;
    protected String userMac;
    protected String userName;
    protected String userTemplateId;
    protected Short userVlan;
    protected String usergroupId;
    protected String wpNasIp;
    protected Long wpNasPort;
    protected String operatorsName;
    protected String operatorsUserId;

    /**
     * Gets the value of the accessType property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getAccessType() {
        return accessType;
    }

    /**
     * Sets the value of the accessType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setAccessType(Short value) {
        this.accessType = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(String value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the apMac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApMac() {
        return apMac;
    }

    /**
     * Sets the value of the apMac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApMac(String value) {
        this.apMac = value;
    }

    /**
     * Gets the value of the areaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * Sets the value of the areaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaName(String value) {
        this.areaName = value;
    }

    /**
     * Gets the value of the dns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDns() {
        return dns;
    }

    /**
     * Sets the value of the dns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDns(String value) {
        this.dns = value;
    }

    /**
     * Gets the value of the gateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * Sets the value of the gateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGateway(String value) {
        this.gateway = value;
    }

    /**
     * Gets the value of the ipv6Gateway property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpv6Gateway() {
        return ipv6Gateway;
    }

    /**
     * Sets the value of the ipv6Gateway property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpv6Gateway(String value) {
        this.ipv6Gateway = value;
    }

    /**
     * Gets the value of the ipv6Num property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getIpv6Num() {
        return ipv6Num;
    }

    /**
     * Sets the value of the ipv6Num property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setIpv6Num(Short value) {
        this.ipv6Num = value;
    }

    /**
     * Gets the value of the nasCommunity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNasCommunity() {
        return nasCommunity;
    }

    /**
     * Sets the value of the nasCommunity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNasCommunity(String value) {
        this.nasCommunity = value;
    }

    /**
     * Gets the value of the nasIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNasIp() {
        return nasIp;
    }

    /**
     * Sets the value of the nasIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNasIp(String value) {
        this.nasIp = value;
    }

    /**
     * Gets the value of the nasIpv6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNasIpv6() {
        return nasIpv6;
    }

    /**
     * Sets the value of the nasIpv6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNasIpv6(String value) {
        this.nasIpv6 = value;
    }

    /**
     * Gets the value of the nasLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNasLocation() {
        return nasLocation;
    }

    /**
     * Sets the value of the nasLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNasLocation(String value) {
        this.nasLocation = value;
    }

    /**
     * Gets the value of the nasName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNasName() {
        return nasName;
    }

    /**
     * Sets the value of the nasName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNasName(String value) {
        this.nasName = value;
    }

    /**
     * Gets the value of the nasPort property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNasPort() {
        return nasPort;
    }

    /**
     * Sets the value of the nasPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNasPort(Long value) {
        this.nasPort = value;
    }

    /**
     * Gets the value of the nasType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNasType() {
        return nasType;
    }

    /**
     * Sets the value of the nasType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNasType(String value) {
        this.nasType = value;
    }

    /**
     * Gets the value of the nasTypeNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNasTypeNum() {
        return nasTypeNum;
    }

    /**
     * Sets the value of the nasTypeNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNasTypeNum(String value) {
        this.nasTypeNum = value;
    }

    /**
     * Gets the value of the netMask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetMask() {
        return netMask;
    }

    /**
     * Sets the value of the netMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetMask(String value) {
        this.netMask = value;
    }

    /**
     * Gets the value of the onlineTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOnlineTime() {
        return onlineTime;
    }

    /**
     * Sets the value of the onlineTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOnlineTime(XMLGregorianCalendar value) {
        this.onlineTime = value;
    }

    /**
     * Gets the value of the packageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Sets the value of the packageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
    }

    /**
     * Gets the value of the policyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * Sets the value of the policyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyId(String value) {
        this.policyId = value;
    }

    /**
     * Gets the value of the serviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * Sets the value of the serviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceId(String value) {
        this.serviceId = value;
    }

    /**
     * Gets the value of the serviceSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceSuffix() {
        return serviceSuffix;
    }

    /**
     * Sets the value of the serviceSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceSuffix(String value) {
        this.serviceSuffix = value;
    }

    /**
     * Gets the value of the ssid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsid() {
        return ssid;
    }

    /**
     * Sets the value of the ssid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsid(String value) {
        this.ssid = value;
    }

    /**
     * Gets the value of the suVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuVersion() {
        return suVersion;
    }

    /**
     * Sets the value of the suVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuVersion(String value) {
        this.suVersion = value;
    }

    /**
     * Gets the value of the timesegmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimesegmentId() {
        return timesegmentId;
    }

    /**
     * Sets the value of the timesegmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimesegmentId(String value) {
        this.timesegmentId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the userIpv4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIpv4() {
        return userIpv4;
    }

    /**
     * Sets the value of the userIpv4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIpv4(String value) {
        this.userIpv4 = value;
    }

    /**
     * Gets the value of the userIpv6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIpv6() {
        return userIpv6;
    }

    /**
     * Sets the value of the userIpv6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIpv6(String value) {
        this.userIpv6 = value;
    }

    /**
     * Gets the value of the userIpv6LocalLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIpv6LocalLink() {
        return userIpv6LocalLink;
    }

    /**
     * Sets the value of the userIpv6LocalLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIpv6LocalLink(String value) {
        this.userIpv6LocalLink = value;
    }

    /**
     * Gets the value of the userMac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserMac() {
        return userMac;
    }

    /**
     * Sets the value of the userMac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserMac(String value) {
        this.userMac = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the userTemplateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserTemplateId() {
        return userTemplateId;
    }

    /**
     * Sets the value of the userTemplateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserTemplateId(String value) {
        this.userTemplateId = value;
    }

    /**
     * Gets the value of the userVlan property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getUserVlan() {
        return userVlan;
    }

    /**
     * Sets the value of the userVlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setUserVlan(Short value) {
        this.userVlan = value;
    }

    /**
     * Gets the value of the usergroupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsergroupId() {
        return usergroupId;
    }

    /**
     * Sets the value of the usergroupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsergroupId(String value) {
        this.usergroupId = value;
    }

    /**
     * Gets the value of the wpNasIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWpNasIp() {
        return wpNasIp;
    }

    /**
     * Sets the value of the wpNasIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWpNasIp(String value) {
        this.wpNasIp = value;
    }

    /**
     * Gets the value of the wpNasPort property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWpNasPort() {
        return wpNasPort;
    }

    /**
     * Sets the value of the wpNasPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWpNasPort(Long value) {
        this.wpNasPort = value;
    }

    /**
     * Gets the value of the operatorsName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorsName() {
        return operatorsName;
    }

    /**
     * Sets the value of the operatorsName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorsName(String value) {
        this.operatorsName = value;
    }

    /**
     * Gets the value of the operatorsUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorsUserId() {
        return operatorsUserId;
    }

    /**
     * Sets the value of the operatorsUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorsUserId(String value) {
        this.operatorsUserId = value;
    }

	@Override
	public String toString() {
		return "OnlineUserInfo [accessType=" + accessType + ", accountId="
				+ accountId + ", apMac=" + apMac + ", areaName=" + areaName
				+ ", dns=" + dns + ", gateway=" + gateway + ", ipv6Gateway="
				+ ipv6Gateway + ", ipv6Num=" + ipv6Num + ", nasCommunity="
				+ nasCommunity + ", nasIp=" + nasIp + ", nasIpv6=" + nasIpv6
				+ ", nasLocation=" + nasLocation + ", nasName=" + nasName
				+ ", nasPort=" + nasPort + ", nasType=" + nasType
				+ ", nasTypeNum=" + nasTypeNum + ", netMask=" + netMask
				+ ", onlineTime=" + onlineTime + ", packageName=" + packageName
				+ ", policyId=" + policyId + ", serviceId=" + serviceId
				+ ", serviceSuffix=" + serviceSuffix + ", ssid=" + ssid
				+ ", suVersion=" + suVersion + ", timesegmentId="
				+ timesegmentId + ", userId=" + userId + ", userIpv4="
				+ userIpv4 + ", userIpv6=" + userIpv6 + ", userIpv6LocalLink="
				+ userIpv6LocalLink + ", userMac=" + userMac + ", userName="
				+ userName + ", userTemplateId=" + userTemplateId
				+ ", userVlan=" + userVlan + ", usergroupId=" + usergroupId
				+ ", wpNasIp=" + wpNasIp + ", wpNasPort=" + wpNasPort
				+ ", operatorsName=" + operatorsName + ", operatorsUserId="
				+ operatorsUserId + "]";
	}

}
