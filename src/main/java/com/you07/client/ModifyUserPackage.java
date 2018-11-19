
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
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userTemplateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userPackageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationTimeType" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "userId",
    "userTemplateName",
    "userPackageName",
    "operationTimeType"
})
@XmlRootElement(name = "modifyUserPackage")
public class ModifyUserPackage {

    protected String userId;
    protected String userTemplateName;
    protected String userPackageName;
    protected int operationTimeType;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the userTemplateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserTemplateName() {
        return userTemplateName;
    }

    /**
     * Sets the value of the userTemplateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserTemplateName(String value) {
        this.userTemplateName = value;
    }

    /**
     * Gets the value of the userPackageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPackageName() {
        return userPackageName;
    }

    /**
     * Sets the value of the userPackageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPackageName(String value) {
        this.userPackageName = value;
    }

    /**
     * Gets the value of the operationTimeType property.
     * 
     */
    public int getOperationTimeType() {
        return operationTimeType;
    }

    /**
     * Sets the value of the operationTimeType property.
     * 
     */
    public void setOperationTimeType(int value) {
        this.operationTimeType = value;
    }

}
