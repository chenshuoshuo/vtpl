package com.you07.location.joywise;

import io.swagger.models.auth.In;

/**
 * @author Egan
 * @date 2019/11/4 10:40
 **/
public class Message {

    private String USERID;

    private String USERIP;

    private String USERNAME;

    private String USERMAC;

    private String NASIP;

    private Integer NASPORT;

    private String WEBGATEWAY;

    private String USERGROUPNAME;

    private Integer ISREPEATAUTH;

    private Long LOGINTIME;

    private String APMAC;

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getUSERIP() {
        return USERIP;
    }

    public void setUSERIP(String USERIP) {
        this.USERIP = USERIP;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getUSERMAC() {
        return USERMAC;
    }

    public void setUSERMAC(String USERMAC) {
        this.USERMAC = USERMAC;
    }

    public String getNASIP() {
        return NASIP;
    }

    public void setNASIP(String NASIP) {
        this.NASIP = NASIP;
    }

    public Integer getNASPORT() {
        return NASPORT;
    }

    public void setNASPORT(Integer NASPORT) {
        this.NASPORT = NASPORT;
    }

    public String getWEBGATEWAY() {
        return WEBGATEWAY;
    }

    public void setWEBGATEWAY(String WEBGATEWAY) {
        this.WEBGATEWAY = WEBGATEWAY;
    }

    public String getUSERGROUPNAME() {
        return USERGROUPNAME;
    }

    public void setUSERGROUPNAME(String USERGROUPNAME) {
        this.USERGROUPNAME = USERGROUPNAME;
    }

    public Integer getISREPEATAUTH() {
        return ISREPEATAUTH;
    }

    public void setISREPEATAUTH(Integer ISREPEATAUTH) {
        this.ISREPEATAUTH = ISREPEATAUTH;
    }

    public Long getLOGINTIME() {
        return LOGINTIME;
    }

    public void setLOGINTIME(Long LOGINTIME) {
        this.LOGINTIME = LOGINTIME;
    }

    public String getAPMAC() {
        return APMAC;
    }

    public void setAPMAC(String APMAC) {
        this.APMAC = APMAC;
    }
}
