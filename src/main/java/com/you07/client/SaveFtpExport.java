
package com.you07.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="ftpServerIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ftpServerPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ftpBakPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ftpUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ftpPass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exportTables" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    "ftpServerIp",
    "ftpServerPort",
    "ftpBakPath",
    "ftpUser",
    "ftpPass",
    "exportTables"
})
@XmlRootElement(name = "saveFtpExport")
public class SaveFtpExport {

    protected String ftpServerIp;
    protected Long ftpServerPort;
    protected String ftpBakPath;
    protected String ftpUser;
    protected String ftpPass;
    protected List<String> exportTables;

    /**
     * Gets the value of the ftpServerIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpServerIp() {
        return ftpServerIp;
    }

    /**
     * Sets the value of the ftpServerIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpServerIp(String value) {
        this.ftpServerIp = value;
    }

    /**
     * Gets the value of the ftpServerPort property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFtpServerPort() {
        return ftpServerPort;
    }

    /**
     * Sets the value of the ftpServerPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFtpServerPort(Long value) {
        this.ftpServerPort = value;
    }

    /**
     * Gets the value of the ftpBakPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpBakPath() {
        return ftpBakPath;
    }

    /**
     * Sets the value of the ftpBakPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpBakPath(String value) {
        this.ftpBakPath = value;
    }

    /**
     * Gets the value of the ftpUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpUser() {
        return ftpUser;
    }

    /**
     * Sets the value of the ftpUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpUser(String value) {
        this.ftpUser = value;
    }

    /**
     * Gets the value of the ftpPass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtpPass() {
        return ftpPass;
    }

    /**
     * Sets the value of the ftpPass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpPass(String value) {
        this.ftpPass = value;
    }

    /**
     * Gets the value of the exportTables property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportTables property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportTables().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExportTables() {
        if (exportTables == null) {
            exportTables = new ArrayList<String>();
        }
        return this.exportTables;
    }

}
