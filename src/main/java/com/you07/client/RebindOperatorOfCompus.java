
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
 *         &lt;element name="oldOperatorUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compusName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newOperatorUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newOperatorUserPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "oldOperatorUserId",
    "compusName",
    "newOperatorUserId",
    "newOperatorUserPassword"
})
@XmlRootElement(name = "rebindOperatorOfCompus")
public class RebindOperatorOfCompus {

    protected String oldOperatorUserId;
    protected String compusName;
    protected String newOperatorUserId;
    protected String newOperatorUserPassword;

    /**
     * Gets the value of the oldOperatorUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldOperatorUserId() {
        return oldOperatorUserId;
    }

    /**
     * Sets the value of the oldOperatorUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldOperatorUserId(String value) {
        this.oldOperatorUserId = value;
    }

    /**
     * Gets the value of the compusName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompusName() {
        return compusName;
    }

    /**
     * Sets the value of the compusName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompusName(String value) {
        this.compusName = value;
    }

    /**
     * Gets the value of the newOperatorUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewOperatorUserId() {
        return newOperatorUserId;
    }

    /**
     * Sets the value of the newOperatorUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewOperatorUserId(String value) {
        this.newOperatorUserId = value;
    }

    /**
     * Gets the value of the newOperatorUserPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewOperatorUserPassword() {
        return newOperatorUserPassword;
    }

    /**
     * Sets the value of the newOperatorUserPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewOperatorUserPassword(String value) {
        this.newOperatorUserPassword = value;
    }

}
