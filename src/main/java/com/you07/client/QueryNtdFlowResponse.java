
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
 *         &lt;element name="queryNtdFlowResult" type="{http://api.spl.ruijie.com/}queryNtdFlowResult" minOccurs="0"/>
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
    "queryNtdFlowResult"
})
@XmlRootElement(name = "queryNtdFlowResponse")
public class QueryNtdFlowResponse {

    protected QueryNtdFlowResult queryNtdFlowResult;

    /**
     * Gets the value of the queryNtdFlowResult property.
     * 
     * @return
     *     possible object is
     *     {@link QueryNtdFlowResult }
     *     
     */
    public QueryNtdFlowResult getQueryNtdFlowResult() {
        return queryNtdFlowResult;
    }

    /**
     * Sets the value of the queryNtdFlowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryNtdFlowResult }
     *     
     */
    public void setQueryNtdFlowResult(QueryNtdFlowResult value) {
        this.queryNtdFlowResult = value;
    }

}
