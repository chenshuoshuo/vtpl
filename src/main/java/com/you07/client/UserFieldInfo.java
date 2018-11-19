
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userFieldInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userFieldInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fieldDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fieldOrder" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="isRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isSelfCanModify" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isShowOnAdmin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isShowOnSelf" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="userFieldType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userFieldInfo", propOrder = {
    "defaultValue",
    "fieldDes",
    "fieldName",
    "fieldOrder",
    "fieldType",
    "isRequired",
    "isSelfCanModify",
    "isShowOnAdmin",
    "isShowOnSelf",
    "userFieldType"
})
public class UserFieldInfo {

    protected String defaultValue;
    protected String fieldDes;
    protected String fieldName;
    protected Long fieldOrder;
    protected Short fieldType;
    protected Boolean isRequired;
    protected Boolean isSelfCanModify;
    protected Boolean isShowOnAdmin;
    protected Boolean isShowOnSelf;
    protected String userFieldType;

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValue(String value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the fieldDes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldDes() {
        return fieldDes;
    }

    /**
     * Sets the value of the fieldDes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldDes(String value) {
        this.fieldDes = value;
    }

    /**
     * Gets the value of the fieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the value of the fieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldName(String value) {
        this.fieldName = value;
    }

    /**
     * Gets the value of the fieldOrder property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFieldOrder() {
        return fieldOrder;
    }

    /**
     * Sets the value of the fieldOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFieldOrder(Long value) {
        this.fieldOrder = value;
    }

    /**
     * Gets the value of the fieldType property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getFieldType() {
        return fieldType;
    }

    /**
     * Sets the value of the fieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setFieldType(Short value) {
        this.fieldType = value;
    }

    /**
     * Gets the value of the isRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRequired() {
        return isRequired;
    }

    /**
     * Sets the value of the isRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRequired(Boolean value) {
        this.isRequired = value;
    }

    /**
     * Gets the value of the isSelfCanModify property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSelfCanModify() {
        return isSelfCanModify;
    }

    /**
     * Sets the value of the isSelfCanModify property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSelfCanModify(Boolean value) {
        this.isSelfCanModify = value;
    }

    /**
     * Gets the value of the isShowOnAdmin property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsShowOnAdmin() {
        return isShowOnAdmin;
    }

    /**
     * Sets the value of the isShowOnAdmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsShowOnAdmin(Boolean value) {
        this.isShowOnAdmin = value;
    }

    /**
     * Gets the value of the isShowOnSelf property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsShowOnSelf() {
        return isShowOnSelf;
    }

    /**
     * Sets the value of the isShowOnSelf property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsShowOnSelf(Boolean value) {
        this.isShowOnSelf = value;
    }

    /**
     * Gets the value of the userFieldType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserFieldType() {
        return userFieldType;
    }

    /**
     * Sets the value of the userFieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserFieldType(String value) {
        this.userFieldType = value;
    }

}
