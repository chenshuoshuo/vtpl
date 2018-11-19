
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tradeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tradeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rgTradeNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tradeNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tradeInfo", propOrder = {
    "rgTradeNo",
    "tradeNo"
})
public class TradeInfo {

    protected String rgTradeNo;
    protected String tradeNo;

    /**
     * Gets the value of the rgTradeNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRgTradeNo() {
        return rgTradeNo;
    }

    /**
     * Sets the value of the rgTradeNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRgTradeNo(String value) {
        this.rgTradeNo = value;
    }

    /**
     * Gets the value of the tradeNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * Sets the value of the tradeNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradeNo(String value) {
        this.tradeNo = value;
    }

}
