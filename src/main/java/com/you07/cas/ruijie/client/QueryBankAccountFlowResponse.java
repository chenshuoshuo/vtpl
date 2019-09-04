
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
 *         &lt;element name="queryBankAccountFlowResult" type="{http://api.spl.ruijie.com/}queryBankAccountFlowResult" minOccurs="0"/>
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
    "queryBankAccountFlowResult"
})
@XmlRootElement(name = "queryBankAccountFlowResponse")
public class QueryBankAccountFlowResponse {

    protected QueryBankAccountFlowResult queryBankAccountFlowResult;

    /**
     * Gets the value of the queryBankAccountFlowResult property.
     * 
     * @return
     *     possible object is
     *     {@link QueryBankAccountFlowResult }
     *     
     */
    public QueryBankAccountFlowResult getQueryBankAccountFlowResult() {
        return queryBankAccountFlowResult;
    }

    /**
     * Sets the value of the queryBankAccountFlowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryBankAccountFlowResult }
     *     
     */
    public void setQueryBankAccountFlowResult(QueryBankAccountFlowResult value) {
        this.queryBankAccountFlowResult = value;
    }

}
