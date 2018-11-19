
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for findAllUserTemplatePackagesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findAllUserTemplatePackagesResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="templatePackages" type="{http://api.spl.ruijie.com/}userPackageTemplate" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllUserTemplatePackagesResult", propOrder = {
    "errorCode",
    "errorMessage",
    "templatePackages"
})
public class FindAllUserTemplatePackagesResult {

    protected int errorCode;
    protected String errorMessage;
    @XmlElement(nillable = true)
    protected List<UserPackageTemplate> templatePackages;

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
     * Gets the value of the templatePackages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templatePackages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplatePackages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserPackageTemplate }
     * 
     * 
     */
    public List<UserPackageTemplate> getTemplatePackages() {
        if (templatePackages == null) {
            templatePackages = new ArrayList<UserPackageTemplate>();
        }
        return this.templatePackages;
    }

}
