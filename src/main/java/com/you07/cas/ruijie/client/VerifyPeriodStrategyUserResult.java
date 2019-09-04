
package com.you07.cas.ruijie.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verifyPeriodStrategyUserResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verifyPeriodStrategyUserResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.spl.ruijie.com/}samApiBaseResult">
 *       &lt;sequence>
 *         &lt;element name="periodUser" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyPeriodStrategyUserResult", propOrder = {
    "periodUser"
})
public class VerifyPeriodStrategyUserResult
    extends SamApiBaseResult
{

    protected boolean periodUser;

    /**
     * Gets the value of the periodUser property.
     * 
     */
    public boolean isPeriodUser() {
        return periodUser;
    }

    /**
     * Sets the value of the periodUser property.
     * 
     */
    public void setPeriodUser(boolean value) {
        this.periodUser = value;
    }

}
