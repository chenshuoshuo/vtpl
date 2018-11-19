
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="blackListFlag" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="blackListExpireTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="blackListMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userId",
    "blackListFlag",
    "blackListExpireTime",
    "blackListMessage"
})
@XmlRootElement(name = "kickOnlineUser")
public class KickOnlineUser {

    protected String userId;
    protected int blackListFlag;
    protected int blackListExpireTime;
    protected String blackListMessage;

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
     * Gets the value of the blackListFlag property.
     * 
     */
    public int getBlackListFlag() {
        return blackListFlag;
    }

    /**
     * Sets the value of the blackListFlag property.
     * 
     */
    public void setBlackListFlag(int value) {
        this.blackListFlag = value;
    }

    /**
     * Gets the value of the blackListExpireTime property.
     * 
     */
    public int getBlackListExpireTime() {
        return blackListExpireTime;
    }

    /**
     * Sets the value of the blackListExpireTime property.
     * 
     */
    public void setBlackListExpireTime(int value) {
        this.blackListExpireTime = value;
    }

    /**
     * Gets the value of the blackListMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlackListMessage() {
        return blackListMessage;
    }

    /**
     * Sets the value of the blackListMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlackListMessage(String value) {
        this.blackListMessage = value;
    }

}
