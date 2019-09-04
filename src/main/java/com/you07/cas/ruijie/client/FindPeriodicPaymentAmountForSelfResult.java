
package com.you07.cas.ruijie.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for findPeriodicPaymentAmountForSelfResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findPeriodicPaymentAmountForSelfResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.spl.ruijie.com/}samApiBaseResult">
 *       &lt;sequence>
 *         &lt;element name="accountFee" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="periodicPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findPeriodicPaymentAmountForSelfResult", propOrder = {
    "accountFee",
    "periodicPaymentAmount"
})
public class FindPeriodicPaymentAmountForSelfResult
    extends SamApiBaseResult
{

    @XmlElement(required = true)
    protected BigDecimal accountFee;
    @XmlElement(required = true)
    protected BigDecimal periodicPaymentAmount;

    /**
     * Gets the value of the accountFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAccountFee() {
        return accountFee;
    }

    /**
     * Sets the value of the accountFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAccountFee(BigDecimal value) {
        this.accountFee = value;
    }

    /**
     * Gets the value of the periodicPaymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPeriodicPaymentAmount() {
        return periodicPaymentAmount;
    }

    /**
     * Sets the value of the periodicPaymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPeriodicPaymentAmount(BigDecimal value) {
        this.periodicPaymentAmount = value;
    }

}
