
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for usedFreeFlow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="usedFreeFlow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chargeType" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="usedFreeFlow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalFreeFlow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zoneAndService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usedFreeFlow", propOrder = {
    "chargeType",
    "usedFreeFlow",
    "totalFreeFlow",
    "zoneAndService"
})
public class UsedFreeFlow {

    protected Short chargeType;
    protected String usedFreeFlow;
    protected String totalFreeFlow;
    protected String zoneAndService;

    /**
     * Gets the value of the chargeType property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getChargeType() {
        return chargeType;
    }

    /**
     * Sets the value of the chargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setChargeType(Short value) {
        this.chargeType = value;
    }

    /**
     * Gets the value of the usedFreeFlow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsedFreeFlow() {
        return usedFreeFlow;
    }

    /**
     * Sets the value of the usedFreeFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsedFreeFlow(String value) {
        this.usedFreeFlow = value;
    }

    /**
     * Gets the value of the totalFreeFlow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalFreeFlow() {
        return totalFreeFlow;
    }

    /**
     * Sets the value of the totalFreeFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalFreeFlow(String value) {
        this.totalFreeFlow = value;
    }

    /**
     * Gets the value of the zoneAndService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneAndService() {
        return zoneAndService;
    }

    /**
     * Sets the value of the zoneAndService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneAndService(String value) {
        this.zoneAndService = value;
    }

}
