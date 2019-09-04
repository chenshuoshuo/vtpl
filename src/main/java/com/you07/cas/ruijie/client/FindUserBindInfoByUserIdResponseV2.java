
package com.you07.cas.ruijie.client;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="return" type="{http://api.spl.ruijie.com/}findUserBindInfoByUserIdResultV2" minOccurs="0"/>
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
    "_return"
})
@XmlRootElement(name = "findUserBindInfoByUserIdResponseV2")
public class FindUserBindInfoByUserIdResponseV2 {

    @XmlElement(name = "return")
    protected FindUserBindInfoByUserIdResultV2 _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link FindUserBindInfoByUserIdResultV2 }
     *     
     */
    public FindUserBindInfoByUserIdResultV2 getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindUserBindInfoByUserIdResultV2 }
     *     
     */
    public void setReturn(FindUserBindInfoByUserIdResultV2 value) {
        this._return = value;
    }

}
