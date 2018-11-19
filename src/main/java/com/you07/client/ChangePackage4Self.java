
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
 *         &lt;element name="packageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="changeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "packageId",
    "changeType"
})
@XmlRootElement(name = "changePackage4Self")
public class ChangePackage4Self {

    protected String userId;
    protected String packageId;
    protected String changeType;

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
     * Gets the value of the packageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * Sets the value of the packageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageId(String value) {
        this.packageId = value;
    }

    /**
     * Gets the value of the changeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeType() {
        return changeType;
    }

    /**
     * Sets the value of the changeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeType(String value) {
        this.changeType = value;
    }

}
