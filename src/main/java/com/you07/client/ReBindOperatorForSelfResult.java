
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reBindOperatorForSelfResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reBindOperatorForSelfResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.spl.ruijie.com/}samApiBaseResult">
 *       &lt;sequence>
 *         &lt;element name="bindTimes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reBindOperatorForSelfResult", propOrder = {
    "bindTimes"
})
public class ReBindOperatorForSelfResult
    extends SamApiBaseResult
{

    protected int bindTimes;

    /**
     * Gets the value of the bindTimes property.
     * 
     */
    public int getBindTimes() {
        return bindTimes;
    }

    /**
     * Sets the value of the bindTimes property.
     * 
     */
    public void setBindTimes(int value) {
        this.bindTimes = value;
    }

}
