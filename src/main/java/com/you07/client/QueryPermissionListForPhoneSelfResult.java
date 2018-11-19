
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for queryPermissionListForPhoneSelfResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="queryPermissionListForPhoneSelfResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.spl.ruijie.com/}samApiBaseResult">
 *       &lt;sequence>
 *         &lt;element name="permissionInfos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryPermissionListForPhoneSelfResult", propOrder = {
    "permissionInfos"
})
public class QueryPermissionListForPhoneSelfResult
    extends SamApiBaseResult
{

    @XmlElement(nillable = true)
    protected List<String> permissionInfos;

    /**
     * Gets the value of the permissionInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permissionInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPermissionInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPermissionInfos() {
        if (permissionInfos == null) {
            permissionInfos = new ArrayList<String>();
        }
        return this.permissionInfos;
    }

}
