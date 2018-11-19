
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verifyManagerPasswordResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verifyManagerPasswordResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.spl.ruijie.com/}samApiBaseResult">
 *       &lt;sequence>
 *         &lt;element name="passwordCorrect" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyManagerPasswordResult", propOrder = {
    "passwordCorrect"
})
public class VerifyManagerPasswordResult
    extends SamApiBaseResult
{

    protected boolean passwordCorrect;

    /**
     * Gets the value of the passwordCorrect property.
     * 
     */
    public boolean isPasswordCorrect() {
        return passwordCorrect;
    }

    /**
     * Sets the value of the passwordCorrect property.
     * 
     */
    public void setPasswordCorrect(boolean value) {
        this.passwordCorrect = value;
    }

}
