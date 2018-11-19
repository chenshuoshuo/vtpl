
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
 *         &lt;element name="queryUsedFreeFlowResult" type="{http://api.spl.ruijie.com/}queryUsedFreeFlowResult" minOccurs="0"/>
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
    "queryUsedFreeFlowResult"
})
@XmlRootElement(name = "queryUsedFreeFlowResponse")
public class QueryUsedFreeFlowResponse {

    protected QueryUsedFreeFlowResult queryUsedFreeFlowResult;

    /**
     * Gets the value of the queryUsedFreeFlowResult property.
     * 
     * @return
     *     possible object is
     *     {@link QueryUsedFreeFlowResult }
     *     
     */
    public QueryUsedFreeFlowResult getQueryUsedFreeFlowResult() {
        return queryUsedFreeFlowResult;
    }

    /**
     * Sets the value of the queryUsedFreeFlowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryUsedFreeFlowResult }
     *     
     */
    public void setQueryUsedFreeFlowResult(QueryUsedFreeFlowResult value) {
        this.queryUsedFreeFlowResult = value;
    }

}
