
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
 *         &lt;element name="queryAccountFlowResult" type="{http://api.spl.ruijie.com/}queryAccountFlowResult" minOccurs="0"/>
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
    "queryAccountFlowResult"
})
@XmlRootElement(name = "queryAccountFlowAllResponse")
public class QueryAccountFlowAllResponse {

    protected QueryAccountFlowResult queryAccountFlowResult;

    /**
     * Gets the value of the queryAccountFlowResult property.
     * 
     * @return
     *     possible object is
     *     {@link QueryAccountFlowResult }
     *     
     */
    public QueryAccountFlowResult getQueryAccountFlowResult() {
        return queryAccountFlowResult;
    }

    /**
     * Sets the value of the queryAccountFlowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryAccountFlowResult }
     *     
     */
    public void setQueryAccountFlowResult(QueryAccountFlowResult value) {
        this.queryAccountFlowResult = value;
    }

}
