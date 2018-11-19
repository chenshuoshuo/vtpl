
package com.you07.client;

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
 *         &lt;element name="return" type="{http://api.spl.ruijie.com/}queryOnlineUserResultV2" minOccurs="0"/>
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
@XmlRootElement(name = "queryOnlineUserResponseV2")
public class QueryOnlineUserResponseV2 {

    @XmlElement(name = "return")
    protected QueryOnlineUserResultV2 _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link QueryOnlineUserResultV2 }
     *     
     */
    public QueryOnlineUserResultV2 getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryOnlineUserResultV2 }
     *     
     */
    public void setReturn(QueryOnlineUserResultV2 value) {
        this._return = value;
    }

}
