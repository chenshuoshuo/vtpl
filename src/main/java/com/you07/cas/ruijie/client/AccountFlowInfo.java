
package com.you07.cas.ruijie.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for accountFlowInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountFlowInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accountFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="accountPreFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="accounttingRule" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="areaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="badBillFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="beginTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="billOut" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="campusDownFlowByte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="campusUpFlowByte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="chargeType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dayComps" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="destroyTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="destroyType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="flowSumComps" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="foreDownComps" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="foreUpComps" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="foreignDownFlowByte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="foreignUpFlowByte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inlandDownComps" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="inlandDownFlowByte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="inlandUpComps" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="inlandUpFlowByte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="managerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="managerIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="monthComps" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ntdFlowCause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oddFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="overRaraftFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="overRaraftFeeLeft" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="packageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="policyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceSuffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sesstionTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="timeComps" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="totalBillFlowByte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="totalTrafficByte" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="trafficComps" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webOpType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="writeOff" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reserved0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserved9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountFlowInfo", propOrder = {
    "accessType",
    "accountFee",
    "accountPreFee",
    "accounttingRule",
    "areaName",
    "badBillFee",
    "beginTime",
    "billOut",
    "campusDownFlowByte",
    "campusUpFlowByte",
    "chargeType",
    "createTime",
    "dayComps",
    "destroyTime",
    "destroyType",
    "fee",
    "flowSumComps",
    "foreDownComps",
    "foreUpComps",
    "foreignDownFlowByte",
    "foreignUpFlowByte",
    "groupId",
    "inlandDownComps",
    "inlandDownFlowByte",
    "inlandUpComps",
    "inlandUpFlowByte",
    "managerId",
    "managerIp",
    "monthComps",
    "ntdFlowCause",
    "oddFee",
    "overRaraftFee",
    "overRaraftFeeLeft",
    "packageName",
    "policyId",
    "serviceId",
    "serviceSuffix",
    "sesstionTime",
    "timeComps",
    "totalBillFlowByte",
    "totalTrafficByte",
    "trafficComps",
    "userId",
    "webOpType",
    "writeOff",
    "reserved0",
    "reserved1",
    "reserved2",
    "reserved3",
    "reserved4",
    "reserved5",
    "reserved6",
    "reserved7",
    "reserved8",
    "reserved9"
})
public class AccountFlowInfo {

    protected int accessType;
    protected BigDecimal accountFee;
    protected BigDecimal accountPreFee;
    protected int accounttingRule;
    protected String areaName;
    protected BigDecimal badBillFee;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar beginTime;
    protected boolean billOut;
    protected BigDecimal campusDownFlowByte;
    protected BigDecimal campusUpFlowByte;
    protected int chargeType;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected long dayComps;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar destroyTime;
    protected int destroyType;
    protected BigDecimal fee;
    protected BigDecimal flowSumComps;
    protected BigDecimal foreDownComps;
    protected BigDecimal foreUpComps;
    protected BigDecimal foreignDownFlowByte;
    protected BigDecimal foreignUpFlowByte;
    protected String groupId;
    protected BigDecimal inlandDownComps;
    protected BigDecimal inlandDownFlowByte;
    protected BigDecimal inlandUpComps;
    protected BigDecimal inlandUpFlowByte;
    protected String managerId;
    protected String managerIp;
    protected long monthComps;
    protected String ntdFlowCause;
    protected BigDecimal oddFee;
    protected BigDecimal overRaraftFee;
    protected BigDecimal overRaraftFeeLeft;
    protected String packageName;
    protected String policyId;
    protected String serviceId;
    protected String serviceSuffix;
    protected long sesstionTime;
    protected long timeComps;
    protected BigDecimal totalBillFlowByte;
    protected BigDecimal totalTrafficByte;
    protected BigDecimal trafficComps;
    protected String userId;
    protected int webOpType;
    protected boolean writeOff;
    protected String reserved0;
    protected String reserved1;
    protected String reserved2;
    protected String reserved3;
    protected String reserved4;
    protected String reserved5;
    protected String reserved6;
    protected String reserved7;
    protected String reserved8;
    protected String reserved9;

    /**
     * Gets the value of the accessType property.
     * 
     */
    public int getAccessType() {
        return accessType;
    }

    /**
     * Sets the value of the accessType property.
     * 
     */
    public void setAccessType(int value) {
        this.accessType = value;
    }

    /**
     * Gets the value of the accountFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAccountFee() {
        return accountFee;
    }

    /**
     * Sets the value of the accountFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAccountFee(BigDecimal value) {
        this.accountFee = value;
    }

    /**
     * Gets the value of the accountPreFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAccountPreFee() {
        return accountPreFee;
    }

    /**
     * Sets the value of the accountPreFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAccountPreFee(BigDecimal value) {
        this.accountPreFee = value;
    }

    /**
     * Gets the value of the accounttingRule property.
     * 
     */
    public int getAccounttingRule() {
        return accounttingRule;
    }

    /**
     * Sets the value of the accounttingRule property.
     * 
     */
    public void setAccounttingRule(int value) {
        this.accounttingRule = value;
    }

    /**
     * Gets the value of the areaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * Sets the value of the areaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaName(String value) {
        this.areaName = value;
    }

    /**
     * Gets the value of the badBillFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBadBillFee() {
        return badBillFee;
    }

    /**
     * Sets the value of the badBillFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBadBillFee(BigDecimal value) {
        this.badBillFee = value;
    }

    /**
     * Gets the value of the beginTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginTime() {
        return beginTime;
    }

    /**
     * Sets the value of the beginTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginTime(XMLGregorianCalendar value) {
        this.beginTime = value;
    }

    /**
     * Gets the value of the billOut property.
     * 
     */
    public boolean isBillOut() {
        return billOut;
    }

    /**
     * Sets the value of the billOut property.
     * 
     */
    public void setBillOut(boolean value) {
        this.billOut = value;
    }

    /**
     * Gets the value of the campusDownFlowByte property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCampusDownFlowByte() {
        return campusDownFlowByte;
    }

    /**
     * Sets the value of the campusDownFlowByte property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCampusDownFlowByte(BigDecimal value) {
        this.campusDownFlowByte = value;
    }

    /**
     * Gets the value of the campusUpFlowByte property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCampusUpFlowByte() {
        return campusUpFlowByte;
    }

    /**
     * Sets the value of the campusUpFlowByte property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCampusUpFlowByte(BigDecimal value) {
        this.campusUpFlowByte = value;
    }

    /**
     * Gets the value of the chargeType property.
     * 
     */
    public int getChargeType() {
        return chargeType;
    }

    /**
     * Sets the value of the chargeType property.
     * 
     */
    public void setChargeType(int value) {
        this.chargeType = value;
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
     * Gets the value of the dayComps property.
     * 
     */
    public long getDayComps() {
        return dayComps;
    }

    /**
     * Sets the value of the dayComps property.
     * 
     */
    public void setDayComps(long value) {
        this.dayComps = value;
    }

    /**
     * Gets the value of the destroyTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDestroyTime() {
        return destroyTime;
    }

    /**
     * Sets the value of the destroyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDestroyTime(XMLGregorianCalendar value) {
        this.destroyTime = value;
    }

    /**
     * Gets the value of the destroyType property.
     * 
     */
    public int getDestroyType() {
        return destroyType;
    }

    /**
     * Sets the value of the destroyType property.
     * 
     */
    public void setDestroyType(int value) {
        this.destroyType = value;
    }

    /**
     * Gets the value of the fee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFee(BigDecimal value) {
        this.fee = value;
    }

    /**
     * Gets the value of the flowSumComps property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFlowSumComps() {
        return flowSumComps;
    }

    /**
     * Sets the value of the flowSumComps property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFlowSumComps(BigDecimal value) {
        this.flowSumComps = value;
    }

    /**
     * Gets the value of the foreDownComps property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForeDownComps() {
        return foreDownComps;
    }

    /**
     * Sets the value of the foreDownComps property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForeDownComps(BigDecimal value) {
        this.foreDownComps = value;
    }

    /**
     * Gets the value of the foreUpComps property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForeUpComps() {
        return foreUpComps;
    }

    /**
     * Sets the value of the foreUpComps property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForeUpComps(BigDecimal value) {
        this.foreUpComps = value;
    }

    /**
     * Gets the value of the foreignDownFlowByte property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForeignDownFlowByte() {
        return foreignDownFlowByte;
    }

    /**
     * Sets the value of the foreignDownFlowByte property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForeignDownFlowByte(BigDecimal value) {
        this.foreignDownFlowByte = value;
    }

    /**
     * Gets the value of the foreignUpFlowByte property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForeignUpFlowByte() {
        return foreignUpFlowByte;
    }

    /**
     * Sets the value of the foreignUpFlowByte property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForeignUpFlowByte(BigDecimal value) {
        this.foreignUpFlowByte = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the inlandDownComps property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInlandDownComps() {
        return inlandDownComps;
    }

    /**
     * Sets the value of the inlandDownComps property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInlandDownComps(BigDecimal value) {
        this.inlandDownComps = value;
    }

    /**
     * Gets the value of the inlandDownFlowByte property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInlandDownFlowByte() {
        return inlandDownFlowByte;
    }

    /**
     * Sets the value of the inlandDownFlowByte property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInlandDownFlowByte(BigDecimal value) {
        this.inlandDownFlowByte = value;
    }

    /**
     * Gets the value of the inlandUpComps property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInlandUpComps() {
        return inlandUpComps;
    }

    /**
     * Sets the value of the inlandUpComps property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInlandUpComps(BigDecimal value) {
        this.inlandUpComps = value;
    }

    /**
     * Gets the value of the inlandUpFlowByte property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInlandUpFlowByte() {
        return inlandUpFlowByte;
    }

    /**
     * Sets the value of the inlandUpFlowByte property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInlandUpFlowByte(BigDecimal value) {
        this.inlandUpFlowByte = value;
    }

    /**
     * Gets the value of the managerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerId() {
        return managerId;
    }

    /**
     * Sets the value of the managerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerId(String value) {
        this.managerId = value;
    }

    /**
     * Gets the value of the managerIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManagerIp() {
        return managerIp;
    }

    /**
     * Sets the value of the managerIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManagerIp(String value) {
        this.managerIp = value;
    }

    /**
     * Gets the value of the monthComps property.
     * 
     */
    public long getMonthComps() {
        return monthComps;
    }

    /**
     * Sets the value of the monthComps property.
     * 
     */
    public void setMonthComps(long value) {
        this.monthComps = value;
    }

    /**
     * Gets the value of the ntdFlowCause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNtdFlowCause() {
        return ntdFlowCause;
    }

    /**
     * Sets the value of the ntdFlowCause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNtdFlowCause(String value) {
        this.ntdFlowCause = value;
    }

    /**
     * Gets the value of the oddFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOddFee() {
        return oddFee;
    }

    /**
     * Sets the value of the oddFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOddFee(BigDecimal value) {
        this.oddFee = value;
    }

    /**
     * Gets the value of the overRaraftFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverRaraftFee() {
        return overRaraftFee;
    }

    /**
     * Sets the value of the overRaraftFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverRaraftFee(BigDecimal value) {
        this.overRaraftFee = value;
    }

    /**
     * Gets the value of the overRaraftFeeLeft property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverRaraftFeeLeft() {
        return overRaraftFeeLeft;
    }

    /**
     * Sets the value of the overRaraftFeeLeft property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverRaraftFeeLeft(BigDecimal value) {
        this.overRaraftFeeLeft = value;
    }

    /**
     * Gets the value of the packageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Sets the value of the packageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackageName(String value) {
        this.packageName = value;
    }

    /**
     * Gets the value of the policyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * Sets the value of the policyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyId(String value) {
        this.policyId = value;
    }

    /**
     * Gets the value of the serviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * Sets the value of the serviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceId(String value) {
        this.serviceId = value;
    }

    /**
     * Gets the value of the serviceSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceSuffix() {
        return serviceSuffix;
    }

    /**
     * Sets the value of the serviceSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceSuffix(String value) {
        this.serviceSuffix = value;
    }

    /**
     * Gets the value of the sesstionTime property.
     * 
     */
    public long getSesstionTime() {
        return sesstionTime;
    }

    /**
     * Sets the value of the sesstionTime property.
     * 
     */
    public void setSesstionTime(long value) {
        this.sesstionTime = value;
    }

    /**
     * Gets the value of the timeComps property.
     * 
     */
    public long getTimeComps() {
        return timeComps;
    }

    /**
     * Sets the value of the timeComps property.
     * 
     */
    public void setTimeComps(long value) {
        this.timeComps = value;
    }

    /**
     * Gets the value of the totalBillFlowByte property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalBillFlowByte() {
        return totalBillFlowByte;
    }

    /**
     * Sets the value of the totalBillFlowByte property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalBillFlowByte(BigDecimal value) {
        this.totalBillFlowByte = value;
    }

    /**
     * Gets the value of the totalTrafficByte property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalTrafficByte() {
        return totalTrafficByte;
    }

    /**
     * Sets the value of the totalTrafficByte property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalTrafficByte(BigDecimal value) {
        this.totalTrafficByte = value;
    }

    /**
     * Gets the value of the trafficComps property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTrafficComps() {
        return trafficComps;
    }

    /**
     * Sets the value of the trafficComps property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTrafficComps(BigDecimal value) {
        this.trafficComps = value;
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

    /**
     * Gets the value of the webOpType property.
     * 
     */
    public int getWebOpType() {
        return webOpType;
    }

    /**
     * Sets the value of the webOpType property.
     * 
     */
    public void setWebOpType(int value) {
        this.webOpType = value;
    }

    /**
     * Gets the value of the writeOff property.
     * 
     */
    public boolean isWriteOff() {
        return writeOff;
    }

    /**
     * Sets the value of the writeOff property.
     * 
     */
    public void setWriteOff(boolean value) {
        this.writeOff = value;
    }

    /**
     * Gets the value of the reserved0 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved0() {
        return reserved0;
    }

    /**
     * Sets the value of the reserved0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved0(String value) {
        this.reserved0 = value;
    }

    /**
     * Gets the value of the reserved1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved1() {
        return reserved1;
    }

    /**
     * Sets the value of the reserved1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved1(String value) {
        this.reserved1 = value;
    }

    /**
     * Gets the value of the reserved2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved2() {
        return reserved2;
    }

    /**
     * Sets the value of the reserved2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved2(String value) {
        this.reserved2 = value;
    }

    /**
     * Gets the value of the reserved3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved3() {
        return reserved3;
    }

    /**
     * Sets the value of the reserved3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved3(String value) {
        this.reserved3 = value;
    }

    /**
     * Gets the value of the reserved4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved4() {
        return reserved4;
    }

    /**
     * Sets the value of the reserved4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved4(String value) {
        this.reserved4 = value;
    }

    /**
     * Gets the value of the reserved5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved5() {
        return reserved5;
    }

    /**
     * Sets the value of the reserved5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved5(String value) {
        this.reserved5 = value;
    }

    /**
     * Gets the value of the reserved6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved6() {
        return reserved6;
    }

    /**
     * Sets the value of the reserved6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved6(String value) {
        this.reserved6 = value;
    }

    /**
     * Gets the value of the reserved7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved7() {
        return reserved7;
    }

    /**
     * Sets the value of the reserved7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved7(String value) {
        this.reserved7 = value;
    }

    /**
     * Gets the value of the reserved8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved8() {
        return reserved8;
    }

    /**
     * Sets the value of the reserved8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved8(String value) {
        this.reserved8 = value;
    }

    /**
     * Gets the value of the reserved9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved9() {
        return reserved9;
    }

    /**
     * Sets the value of the reserved9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved9(String value) {
        this.reserved9 = value;
    }

}
