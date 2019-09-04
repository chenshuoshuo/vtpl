
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
 *         &lt;element name="queryLoginFailLogParams" type="{http://api.spl.ruijie.com/}queryLoginFailLogParams" minOccurs="0"/>
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
    "queryLoginFailLogParams"
})
@XmlRootElement(name = "queryLoginFailLog")
public class QueryLoginFailLog {

    protected QueryLoginFailLogParams queryLoginFailLogParams;

    /**
     * Gets the value of the queryLoginFailLogParams property.
     * 
     * @return
     *     possible object is
     *     {@link QueryLoginFailLogParams }
     *     
     */
    public QueryLoginFailLogParams getQueryLoginFailLogParams() {
        return queryLoginFailLogParams;
    }

    /**
     * Sets the value of the queryLoginFailLogParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryLoginFailLogParams }
     *     
     */
    public void setQueryLoginFailLogParams(QueryLoginFailLogParams value) {
        this.queryLoginFailLogParams = value;
    }

}
