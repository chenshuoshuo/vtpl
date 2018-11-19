
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for onlineDetailInfoV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="onlineDetailInfoV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountingRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internetAccessFee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isRoaming" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="loginTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="logoutTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nasIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasIpv6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="onlineSec" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proxyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="terminateCause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timesegmentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalTraffic" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="tunnelClient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tunnelServer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userTemplateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usergroupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wpNasIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wpNasPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ceVlan" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="peVlan" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="domainName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="terminalTypeDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="terminalOperationSystem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "onlineDetailInfoV2", propOrder = {
    "accountId",
    "accountingRule",
    "apMac",
    "areaName",
    "internetAccessFee",
    "isRoaming",
    "loginTime",
    "logoutTime",
    "nasIp",
    "nasIpv6",
    "onlineSec",
    "packageName",
    "policyId",
    "proxyName",
    "serviceId",
    "serviceSuffix",
    "ssid",
    "suVersion",
    "terminateCause",
    "timesegmentId",
    "totalTraffic",
    "tunnelClient",
    "tunnelServer",
    "userId",
    "userIpv4",
    "userIpv6",
    "userMac",
    "userTemplateId",
    "usergroupId",
    "wpNasIp",
    "wpNasPort",
    "ceVlan",
    "peVlan",
    "domainName",
    "terminalTypeDes",
    "terminalOperationSystem"
})
public class OnlineDetailInfoV2 {

    protected String accountId;
    protected String accountingRule;
    protected String apMac;
    protected String areaName;
    protected String internetAccessFee;
    protected Boolean isRoaming;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar loginTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar logoutTime;
    protected String nasIp;
    protected String nasIpv6;
    protected Long onlineSec;
    protected String packageName;
    protected String policyId;
    protected String proxyName;
    protected String serviceId;
    protected String serviceSuffix;
    protected String ssid;
    protected String suVersion;
    protected String terminateCause;
    protected String timesegmentId;
    protected BigDecimal totalTraffic;
    protected String tunnelClient;
    protected String tunnelServer;
    protected String userId;
    protected String userIpv4;
    protected String userIpv6;
    protected String userMac;
    protected String userTemplateId;
    protected String usergroupId;
    protected String wpNasIp;
    protected Long wpNasPort;
    protected Short ceVlan;
    protected Short peVlan;
    protected String domainName;
    protected String terminalTypeDes;
    protected String terminalOperationSystem;

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
     * Gets the value of the accountingRule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingRule() {
        return accountingRule;
    }

    /**
     * Sets the value of the accountingRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingRule(String value) {
        this.accountingRule = value;
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
     * Gets the value of the internetAccessFee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternetAccessFee() {
        return internetAccessFee;
    }

    /**
     * Sets the value of the internetAccessFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternetAccessFee(String value) {
        this.internetAccessFee = value;
    }

    /**
     * Gets the value of the isRoaming property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRoaming() {
        return isRoaming;
    }

    /**
     * Sets the value of the isRoaming property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRoaming(Boolean value) {
        this.isRoaming = value;
    }

    /**
     * Gets the value of the loginTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoginTime() {
        return loginTime;
    }

    /**
     * Sets the value of the loginTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoginTime(XMLGregorianCalendar value) {
        this.loginTime = value;
    }

    /**
     * Gets the value of the logoutTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLogoutTime() {
        return logoutTime;
    }

    /**
     * Sets the value of the logoutTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLogoutTime(XMLGregorianCalendar value) {
        this.logoutTime = value;
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
     * Gets the value of the onlineSec property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOnlineSec() {
        return onlineSec;
    }

    /**
     * Sets the value of the onlineSec property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOnlineSec(Long value) {
        this.onlineSec = value;
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
     * Gets the value of the proxyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyName() {
        return proxyName;
    }

    /**
     * Sets the value of the proxyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyName(String value) {
        this.proxyName = value;
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
     * Gets the value of the terminateCause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminateCause() {
        return terminateCause;
    }

    /**
     * Sets the value of the terminateCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminateCause(String value) {
        this.terminateCause = value;
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
     * Gets the value of the totalTraffic property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalTraffic() {
        return totalTraffic;
    }

    /**
     * Sets the value of the totalTraffic property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalTraffic(BigDecimal value) {
        this.totalTraffic = value;
    }

    /**
     * Gets the value of the tunnelClient property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTunnelClient() {
        return tunnelClient;
    }

    /**
     * Sets the value of the tunnelClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTunnelClient(String value) {
        this.tunnelClient = value;
    }

    /**
     * Gets the value of the tunnelServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTunnelServer() {
        return tunnelServer;
    }

    /**
     * Sets the value of the tunnelServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTunnelServer(String value) {
        this.tunnelServer = value;
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
     * Gets the value of the ceVlan property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCeVlan() {
        return ceVlan;
    }

    /**
     * Sets the value of the ceVlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCeVlan(Short value) {
        this.ceVlan = value;
    }

    /**
     * Gets the value of the peVlan property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getPeVlan() {
        return peVlan;
    }

    /**
     * Sets the value of the peVlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setPeVlan(Short value) {
        this.peVlan = value;
    }

    /**
     * Gets the value of the domainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Sets the value of the domainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainName(String value) {
        this.domainName = value;
    }

    /**
     * Gets the value of the terminalTypeDes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalTypeDes() {
        return terminalTypeDes;
    }

    /**
     * Sets the value of the terminalTypeDes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalTypeDes(String value) {
        this.terminalTypeDes = value;
    }

    /**
     * Gets the value of the terminalOperationSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalOperationSystem() {
        return terminalOperationSystem;
    }

    /**
     * Sets the value of the terminalOperationSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalOperationSystem(String value) {
        this.terminalOperationSystem = value;
    }

}
