
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
 *         &lt;element name="spiUserBindInfoV2" type="{http://api.spl.ruijie.com/}spiUserBindInfoV2" minOccurs="0"/>
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
    "spiUserBindInfoV2"
})
@XmlRootElement(name = "addUserBindInfoV2")
public class AddUserBindInfoV2 {

    protected String userId;
    protected SpiUserBindInfoV2 spiUserBindInfoV2;

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
     * Gets the value of the spiUserBindInfoV2 property.
     * 
     * @return
     *     possible object is
     *     {@link SpiUserBindInfoV2 }
     *     
     */
    public SpiUserBindInfoV2 getSpiUserBindInfoV2() {
        return spiUserBindInfoV2;
    }

    /**
     * Sets the value of the spiUserBindInfoV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpiUserBindInfoV2 }
     *     
     */
    public void setSpiUserBindInfoV2(SpiUserBindInfoV2 value) {
        this.spiUserBindInfoV2 = value;
    }

}
