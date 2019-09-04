
package com.you07.cas.ruijie.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendMessageV2Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendMessageV2Result">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.spl.ruijie.com/}samApiBaseResult">
 *       &lt;sequence>
 *         &lt;element name="messageSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendMessageV2Result", propOrder = {
    "messageSent"
})
public class SendMessageV2Result
    extends SamApiBaseResult
{

    protected boolean messageSent;

    /**
     * Gets the value of the messageSent property.
     * 
     */
    public boolean isMessageSent() {
        return messageSent;
    }

    /**
     * Sets the value of the messageSent property.
     * 
     */
    public void setMessageSent(boolean value) {
        this.messageSent = value;
    }

}
