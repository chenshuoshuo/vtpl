package com.you07.location.h3cup.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 华三泛定位配置信息
 * @author RY
 * @since 2018-9-4 09:31:53
 * @version 1.0
 */

@Component
@ConfigurationProperties(prefix = "location.h3c-up")
public class H3cUpConfig {
    /**
     * 服务器IP地址
     */
    private String host;
    /**
     * 服务器端口
     */
    private Integer port;
    /**
     * 认证账号
     */
    private String usr;
    /**
     * 认证密码
     */
    private String pwd;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
