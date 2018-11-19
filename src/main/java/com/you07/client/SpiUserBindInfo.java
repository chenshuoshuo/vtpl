
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for spiUserBindInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="spiUserBindInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessType" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="apMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listDefaultShow" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nasIpv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasIpv6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ssid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userBindInfoUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userInfoUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wpNasIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wpNasPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "spiUserBindInfo", propOrder = {
    "accessType",
    "apMac",
    "listDefaultShow",
    "nasIpv4",
    "nasIpv6",
    "nasPort",
    "ssid",
    "userBindInfoUuid",
    "userInfoUuid",
    "userIpv4",
    "userIpv6",
    "userMac",
    "wpNasIp",
    "wpNasPort"
})
public class SpiUserBindInfo {

    protected Short accessType;
    protected String apMac;
    protected Integer listDefaultShow;
    protected String nasIpv4;
    protected String nasIpv6;
    protected Long nasPort;
    protected String ssid;
    protected String userBindInfoUuid;
    protected String userInfoUuid;
    protected String userIpv4;
    protected String userIpv6;
    protected String userMac;
    protected String wpNasIp;
    protected Long wpNasPort;

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
     * Gets the value of the listDefaultShow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getListDefaultShow() {
        return listDefaultShow;
    }

    /**
     * Sets the value of the listDefaultShow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setListDefaultShow(Integer value) {
        this.listDefaultShow = value;
    }

    /**
     * Gets the value of the nasIpv4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNasIpv4() {
        return nasIpv4;
    }

    /**
     * Sets the value of the nasIpv4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNasIpv4(String value) {
        this.nasIpv4 = value;
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
     * Gets the value of the userBindInfoUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserBindInfoUuid() {
        return userBindInfoUuid;
    }

    /**
     * Sets the value of the userBindInfoUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserBindInfoUuid(String value) {
        this.userBindInfoUuid = value;
    }

    /**
     * Gets the value of the userInfoUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserInfoUuid() {
        return userInfoUuid;
    }

    /**
     * Sets the value of the userInfoUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserInfoUuid(String value) {
        this.userInfoUuid = value;
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

}
