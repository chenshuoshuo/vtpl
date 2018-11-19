
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userPackageTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userPackageTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userPackageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userTemplateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userPackageTemplate", propOrder = {
    "userPackageId",
    "userTemplateId"
})
public class UserPackageTemplate {

    protected String userPackageId;
    protected String userTemplateId;

    /**
     * Gets the value of the userPackageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPackageId() {
        return userPackageId;
    }

    /**
     * Sets the value of the userPackageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPackageId(String value) {
        this.userPackageId = value;
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

}
