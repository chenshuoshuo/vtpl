
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for queryOnlineUserResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryOnlineUserResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="onlineUserInfos" type="{http://api.spl.ruijie.com/}onlineUserInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryOnlineUserResult", propOrder = {
    "errorCode",
    "errorMessage",
    "onlineUserInfos",
    "total"
})
public class QueryOnlineUserResult {

    protected int errorCode;
    protected String errorMessage;
    @XmlElement(nillable = true)
    protected List<OnlineUserInfo> onlineUserInfos;
    protected int total;

    /**
     * Gets the value of the errorCode property.
     * 
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     */
    public void setErrorCode(int value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the onlineUserInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onlineUserInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnlineUserInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OnlineUserInfo }
     * 
     * 
     */
    public List<OnlineUserInfo> getOnlineUserInfos() {
        if (onlineUserInfos == null) {
            onlineUserInfos = new ArrayList<OnlineUserInfo>();
        }
        return this.onlineUserInfos;
    }

    /**
     * Gets the value of the total property.
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     */
    public void setTotal(int value) {
        this.total = value;
    }

}
