
package com.you07.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for inhibitInfoV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inhibitInfoV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ceVlan" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="peVlan" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="domainName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inhibitUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isValid" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasIpv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasIpv6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nasPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ssid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv4Ext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userIpv6Ext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="wpNasIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wpNasPort" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ceVlan" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="peVlan" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="domainName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inhibitInfoV2", propOrder = {
    "content"
})
public class InhibitInfoV2 {

    @XmlElementRefs({
        @XmlElementRef(name = "userIpv6Ext", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "isValid", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "apMac", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "userId", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "userMac", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "userIpv6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ceVlan", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "inhibitUuid", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "wpNasIp", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "peVlan", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "validTime", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "nasPort", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "wpNasPort", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "domainName", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "nasIpv4", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "userIpv4Ext", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ssid", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "nasIpv6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "userIpv4", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "memo", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "CeVlan" is used by two different parts of a schema. See: 
     * line 462 of http://10.100.200.1:8080/sam/services/samapi?wsdl
     * line 442 of http://10.100.200.1:8080/sam/services/samapi?wsdl
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Long }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

}
