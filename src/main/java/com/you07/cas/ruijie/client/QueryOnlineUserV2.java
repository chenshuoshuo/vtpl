
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
 *         &lt;element name="param" type="{http://api.spl.ruijie.com/}queryOnlineUserParam" minOccurs="0"/>
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
    "param"
})
@XmlRootElement(name = "queryOnlineUserV2")
public class QueryOnlineUserV2 {

    protected QueryOnlineUserParam param;

    /**
     * Gets the value of the param property.
     * 
     * @return
     *     possible object is
     *     {@link QueryOnlineUserParam }
     *     
     */
    public QueryOnlineUserParam getParam() {
        return param;
    }

    /**
     * Sets the value of the param property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryOnlineUserParam }
     *     
     */
    public void setParam(QueryOnlineUserParam value) {
        this.param = value;
    }

}
