package com.you07.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.you07.config.RestTemplateInterceptor;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author wells
 * @ClassNmae RestTemplateUtil
 * @Description TODO
 * @Date 2019/6/3 11:13
 * @Version 1.0
 **/
public class RestTemplateUtil {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final static String username = "free";
    private final static String password = "123456";
    private final static String secret = "cmccr-guest";

    private static RestTemplateInterceptor getAccessToken() throws IOException {
        // 获取默认的请求客户端
        CloseableHttpClient client = HttpClients.createDefault();
        // 通过HttpPost来发送post请求
//        HttpPost httpPostMethod = new HttpPost("https://testgis.you07.com/cmccr-server/oauth/token?grant_type=password&username=free&password=123456");
        HttpPost httpPostMethod = new HttpPost("https://testgis.you07.com/cmccr-server/oauth/token?grant_type=client_credentials&client_id=cmccr-guest&client_secret=cmccr-guest");


//        httpPostMethod.setHeader("authorization", "Basic Y21jY3ItaDU6Y21jY3ItaDU=");
//        httpPostMethod.setHeader("Content-Type", "application/x-www-form-urlencoded");
        CloseableHttpResponse response = null;
        response = client.execute(httpPostMethod);
        HttpEntity entity = response.getEntity();
        String str = EntityUtils.toString(entity, "UTF-8");
        response.close();
        AccessTokenResponse tokenResponse = objectMapper.readValue(str, AccessTokenResponse.class);

        if(!StringUtils.isNotBlank(tokenResponse.getAccess_token()))
            throw new IOException("获取token失败");

        return new RestTemplateInterceptor(tokenResponse);

    }

    public static JSONObject getJSONObjectForCmGis(String url) {
        RestTemplateInterceptor interceptor = null;
        try {
            interceptor = getAccessToken();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("utf-8")));
//        String requestUrl = url + requestMap + "?" + requestParam;
        if (interceptor != null) {
            restTemplate.setInterceptors(Collections.singletonList(interceptor));
        }
        JSONObject responseJson = restTemplate.getForEntity(url, JSONObject.class).getBody();
        return responseJson;
    }
}
