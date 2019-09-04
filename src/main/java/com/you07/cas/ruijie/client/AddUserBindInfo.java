
package com.you07.cas.ruijie.client;

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
 *         &lt;element name="spiUserBindInfo" type="{http://api.spl.ruijie.com/}spiUserBindInfo" minOccurs="0"/>
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
    "spiUserBindInfo"
})
@XmlRootElement(name = "addUserBindInfo")
public class AddUserBindInfo {

    protected String userId;
    protected SpiUserBindInfo spiUserBindInfo;

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
     * Gets the value of the spiUserBindInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SpiUserBindInfo }
     *     
     */
    public SpiUserBindInfo getSpiUserBindInfo() {
        return spiUserBindInfo;
    }

    /**
     * Sets the value of the spiUserBindInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpiUserBindInfo }
     *     
     */
    public void setSpiUserBindInfo(SpiUserBindInfo value) {
        this.spiUserBindInfo = value;
    }

}
