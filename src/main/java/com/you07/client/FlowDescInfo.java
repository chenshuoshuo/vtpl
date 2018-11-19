
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flowDescInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flowDescInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chargeDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usedFreeDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flowDescInfo", propOrder = {
    "chargeDesc",
    "usedFreeDesc"
})
public class FlowDescInfo {

    protected String chargeDesc;
    protected String usedFreeDesc;

    /**
     * Gets the value of the chargeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeDesc() {
        return chargeDesc;
    }

    /**
     * Sets the value of the chargeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeDesc(String value) {
        this.chargeDesc = value;
    }

    /**
     * Gets the value of the usedFreeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsedFreeDesc() {
        return usedFreeDesc;
    }

    /**
     * Sets the value of the usedFreeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsedFreeDesc(String value) {
        this.usedFreeDesc = value;
    }

}
