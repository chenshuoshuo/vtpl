
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for userPolicyChangeName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userPolicyChangeName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancelTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastUpdateHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastUpdateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="newPolicyInfoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newUserTemplateId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newUserpackageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldPolicyInfoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldUserpackageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operationTimeType" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="processState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="processTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="sourceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userPolicyChangeName", propOrder = {
    "cancelTime",
    "createHost",
    "createTime",
    "lastUpdateHost",
    "lastUpdateTime",
    "newPolicyInfoId",
    "newUserTemplateId",
    "newUserpackageId",
    "oldPolicyInfoId",
    "oldUserpackageId",
    "operationTimeType",
    "operatorId",
    "processState",
    "processTime",
    "sourceType",
    "userId"
})
public class UserPolicyChangeName {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cancelTime;
    protected String createHost;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected String lastUpdateHost;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateTime;
    protected String newPolicyInfoId;
    protected String newUserTemplateId;
    protected String newUserpackageId;
    protected String oldPolicyInfoId;
    protected String oldUserpackageId;
    protected Short operationTimeType;
    protected String operatorId;
    protected int processState;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processTime;
    protected int sourceType;
    protected String userId;

    /**
     * Gets the value of the cancelTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCancelTime() {
        return cancelTime;
    }

    /**
     * Sets the value of the cancelTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCancelTime(XMLGregorianCalendar value) {
        this.cancelTime = value;
    }

    /**
     * Gets the value of the createHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateHost() {
        return createHost;
    }

    /**
     * Sets the value of the createHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateHost(String value) {
        this.createHost = value;
    }

    /**
     * Gets the value of the createTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * Sets the value of the createTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * Gets the value of the lastUpdateHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdateHost() {
        return lastUpdateHost;
    }

    /**
     * Sets the value of the lastUpdateHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdateHost(String value) {
        this.lastUpdateHost = value;
    }

    /**
     * Gets the value of the lastUpdateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * Sets the value of the lastUpdateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateTime(XMLGregorianCalendar value) {
        this.lastUpdateTime = value;
    }

    /**
     * Gets the value of the newPolicyInfoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPolicyInfoId() {
        return newPolicyInfoId;
    }

    /**
     * Sets the value of the newPolicyInfoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPolicyInfoId(String value) {
        this.newPolicyInfoId = value;
    }

    /**
     * Gets the value of the newUserTemplateId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewUserTemplateId() {
        return newUserTemplateId;
    }

    /**
     * Sets the value of the newUserTemplateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewUserTemplateId(String value) {
        this.newUserTemplateId = value;
    }

    /**
     * Gets the value of the newUserpackageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewUserpackageId() {
        return newUserpackageId;
    }

    /**
     * Sets the value of the newUserpackageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewUserpackageId(String value) {
        this.newUserpackageId = value;
    }

    /**
     * Gets the value of the oldPolicyInfoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldPolicyInfoId() {
        return oldPolicyInfoId;
    }

    /**
     * Sets the value of the oldPolicyInfoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldPolicyInfoId(String value) {
        this.oldPolicyInfoId = value;
    }

    /**
     * Gets the value of the oldUserpackageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldUserpackageId() {
        return oldUserpackageId;
    }

    /**
     * Sets the value of the oldUserpackageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldUserpackageId(String value) {
        this.oldUserpackageId = value;
    }

    /**
     * Gets the value of the operationTimeType property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getOperationTimeType() {
        return operationTimeType;
    }

    /**
     * Sets the value of the operationTimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setOperationTimeType(Short value) {
        this.operationTimeType = value;
    }

    /**
     * Gets the value of the operatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * Sets the value of the operatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorId(String value) {
        this.operatorId = value;
    }

    /**
     * Gets the value of the processState property.
     * 
     */
    public int getProcessState() {
        return processState;
    }

    /**
     * Sets the value of the processState property.
     * 
     */
    public void setProcessState(int value) {
        this.processState = value;
    }

    /**
     * Gets the value of the processTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessTime() {
        return processTime;
    }

    /**
     * Sets the value of the processTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessTime(XMLGregorianCalendar value) {
        this.processTime = value;
    }

    /**
     * Gets the value of the sourceType property.
     * 
     */
    public int getSourceType() {
        return sourceType;
    }

    /**
     * Sets the value of the sourceType property.
     * 
     */
    public void setSourceType(int value) {
        this.sourceType = value;
    }

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

}
