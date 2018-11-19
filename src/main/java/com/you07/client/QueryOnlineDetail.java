
package com.you07.client;

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
 *         &lt;element name="queryOnlineDetailParams" type="{http://api.spl.ruijie.com/}queryOnlineDetailParams" minOccurs="0"/>
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
    "queryOnlineDetailParams"
})
@XmlRootElement(name = "queryOnlineDetail")
public class QueryOnlineDetail {

    protected QueryOnlineDetailParams queryOnlineDetailParams;

    /**
     * Gets the value of the queryOnlineDetailParams property.
     * 
     * @return
     *     possible object is
     *     {@link QueryOnlineDetailParams }
     *     
     */
    public QueryOnlineDetailParams getQueryOnlineDetailParams() {
        return queryOnlineDetailParams;
    }

    /**
     * Sets the value of the queryOnlineDetailParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryOnlineDetailParams }
     *     
     */
    public void setQueryOnlineDetailParams(QueryOnlineDetailParams value) {
        this.queryOnlineDetailParams = value;
    }

}
