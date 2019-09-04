
package com.you07.cas.ruijie.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for accountingInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountingInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountState" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="canOverdraft" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="overdraftFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="overdraftFeeLeft" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="preAccountFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountingInfo", propOrder = {
    "accountFee",
    "accountId",
    "accountState",
    "canOverdraft",
    "overdraftFee",
    "overdraftFeeLeft",
    "preAccountFee"
})
public class AccountingInfo {

    protected BigDecimal accountFee;
    protected String accountId;
    protected Short accountState;
    protected boolean canOverdraft;
    protected BigDecimal overdraftFee;
    protected BigDecimal overdraftFeeLeft;
    protected BigDecimal preAccountFee;

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
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(String value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the accountState property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getAccountState() {
        return accountState;
    }

    /**
     * Sets the value of the accountState property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setAccountState(Short value) {
        this.accountState = value;
    }

    /**
     * Gets the value of the canOverdraft property.
     * 
     */
    public boolean isCanOverdraft() {
        return canOverdraft;
    }

    /**
     * Sets the value of the canOverdraft property.
     * 
     */
    public void setCanOverdraft(boolean value) {
        this.canOverdraft = value;
    }

    /**
     * Gets the value of the overdraftFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverdraftFee() {
        return overdraftFee;
    }

    /**
     * Sets the value of the overdraftFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverdraftFee(BigDecimal value) {
        this.overdraftFee = value;
    }

    /**
     * Gets the value of the overdraftFeeLeft property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverdraftFeeLeft() {
        return overdraftFeeLeft;
    }

    /**
     * Sets the value of the overdraftFeeLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverdraftFeeLeft(BigDecimal value) {
        this.overdraftFeeLeft = value;
    }

    /**
     * Gets the value of the preAccountFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPreAccountFee() {
        return preAccountFee;
    }

    /**
     * Sets the value of the preAccountFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPreAccountFee(BigDecimal value) {
        this.preAccountFee = value;
    }

}
