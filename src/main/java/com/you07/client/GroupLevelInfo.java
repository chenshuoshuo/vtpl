
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for groupLevelInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="groupLevelInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="groupinfoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupinfoParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "groupLevelInfo", propOrder = {
    "groupinfoId",
    "groupinfoParentId"
})
public class GroupLevelInfo {

    protected String groupinfoId;
    protected String groupinfoParentId;

    /**
     * Gets the value of the groupinfoId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupinfoId() {
        return groupinfoId;
    }

    /**
     * Sets the value of the groupinfoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupinfoId(String value) {
        this.groupinfoId = value;
    }

    /**
     * Gets the value of the groupinfoParentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupinfoParentId() {
        return groupinfoParentId;
    }

    /**
     * Sets the value of the groupinfoParentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupinfoParentId(String value) {
        this.groupinfoParentId = value;
    }

}
