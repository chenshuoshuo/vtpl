
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
 *         &lt;element name="queryUserResult" type="{http://api.spl.ruijie.com/}queryUserResult" minOccurs="0"/>
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
    "queryUserResult"
})
@XmlRootElement(name = "queryUserResponse")
public class QueryUserResponse {

    protected QueryUserResult queryUserResult;

    /**
     * Gets the value of the queryUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link QueryUserResult }
     *     
     */
    public QueryUserResult getQueryUserResult() {
        return queryUserResult;
    }

    /**
     * Sets the value of the queryUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryUserResult }
     *     
     */
    public void setQueryUserResult(QueryUserResult value) {
        this.queryUserResult = value;
    }

}
