
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
 *         &lt;element name="findSelfServPermResult" type="{http://api.spl.ruijie.com/}findSelfServPermResult" minOccurs="0"/>
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
    "findSelfServPermResult"
})
@XmlRootElement(name = "findSelfServPermResponse")
public class FindSelfServPermResponse {

    protected FindSelfServPermResult findSelfServPermResult;

    /**
     * Gets the value of the findSelfServPermResult property.
     * 
     * @return
     *     possible object is
     *     {@link FindSelfServPermResult }
     *     
     */
    public FindSelfServPermResult getFindSelfServPermResult() {
        return findSelfServPermResult;
    }

    /**
     * Sets the value of the findSelfServPermResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FindSelfServPermResult }
     *     
     */
    public void setFindSelfServPermResult(FindSelfServPermResult value) {
        this.findSelfServPermResult = value;
    }

}
