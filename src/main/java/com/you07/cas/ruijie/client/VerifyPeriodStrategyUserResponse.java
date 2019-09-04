
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
 *         &lt;element name="verifyPeriodStrategyUserResult" type="{http://api.spl.ruijie.com/}verifyPeriodStrategyUserResult" minOccurs="0"/>
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
    "verifyPeriodStrategyUserResult"
})
@XmlRootElement(name = "verifyPeriodStrategyUserResponse")
public class VerifyPeriodStrategyUserResponse {

    protected VerifyPeriodStrategyUserResult verifyPeriodStrategyUserResult;

    /**
     * Gets the value of the verifyPeriodStrategyUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link VerifyPeriodStrategyUserResult }
     *     
     */
    public VerifyPeriodStrategyUserResult getVerifyPeriodStrategyUserResult() {
        return verifyPeriodStrategyUserResult;
    }

    /**
     * Sets the value of the verifyPeriodStrategyUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerifyPeriodStrategyUserResult }
     *     
     */
    public void setVerifyPeriodStrategyUserResult(VerifyPeriodStrategyUserResult value) {
        this.verifyPeriodStrategyUserResult = value;
    }

}
