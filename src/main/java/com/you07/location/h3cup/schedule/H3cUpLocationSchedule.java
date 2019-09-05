package com.you07.location.h3cup.schedule;

import com.you07.location.h3cup.config.H3cUpConfig;
import com.you07.location.h3cup.model.H3cUpAp;
import com.you07.location.h3cup.service.H3cUpApService;
import com.you07.map.service.MapService;
import com.you07.map.vo.MapInfoVO;
import com.you07.vtpl.model.LocationLatest;
import com.you07.vtpl.service.LocationLatestService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.util.StringUtil;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 华三泛定位-定时任务
 */

@Component
public class H3cUpLocationSchedule {
    @Autowired
    private LocationLatestService locationLatestService;
    @Autowired
    private H3cUpApService h3cUpApService;
    @Autowired
    private MapService mapService;

    private static Map<String, H3cUpAp> LOCATION_AP_MAP = new HashMap<>();
    private H3cUpConfig h3cUpConfig;

    private HttpClient client = null;
    private GetMethod get = null;

    public H3cUpLocationSchedule(){};

    public H3cUpLocationSchedule(H3cUpConfig h3cUpConfig){
        this.h3cUpConfig = h3cUpConfig;
    }

    public void updateH3cUploactionSchedule(){
        try {
            initMap();
            if(client == null){
                client = new HttpClient();
                HttpConnectionManagerParams params =
                        client.getHttpConnectionManager().getParams();
                params.setConnectionTimeout(5000);
                params.setSoTimeout(50000);
                params.setSendBufferSize(8192);
                params.setReceiveBufferSize(8192);
                // 使用 HTTP 访问
                client.getHostConfiguration().setHost(h3cUpConfig.getHost(), h3cUpConfig.getPort());
                client.getState().setCredentials(
                        new AuthScope(h3cUpConfig.getHost(), h3cUpConfig.getPort(), "iMC RESTful Web Services"),
                        new UsernamePasswordCredentials(h3cUpConfig.getUsr(), h3cUpConfig.getPwd()));
            }

            get = new GetMethod("/imcrs/wlan/clientInfo/queryAllClientBasicInfo?start=0&size=1000000");
            get.addRequestHeader("accept", "application/xml");
            client.executeMethod(get);
//            InputStream responseStream = get.getResponseBodyAsStream();
            String responseData = get.getResponseBodyAsString();
            if(responseData != null && !"".equals(responseData)){
                responseData = new String(responseData.getBytes("ISO-8859-1"), "UTF-8");

                Document document = DocumentHelper.parseText(responseData);
                Element root = document.getRootElement();
                List<Element> listElement=root.elements();
                for(Element e : listElement){
                    String mac = e.elementText("mac").replaceAll(":", "");
                    String apLabel = e.elementText("apLabel");
//                    System.out.println("mac:" + mac + ",apLabel:" + apLabel);
                    if(StringUtil.isNotEmpty(mac) && StringUtil.isNotEmpty(apLabel) && LOCATION_AP_MAP.containsKey(apLabel)){
                        H3cUpAp h3cUpAp = LOCATION_AP_MAP.get(apLabel);
                        LocationLatest locationLatest = locationLatestService.loadByAccountMac(mac);
                        if(locationLatest != null){
                            locationLatest.setLng(h3cUpAp.getLng());
                            locationLatest.setLat(h3cUpAp.getLat());
                            locationLatest.setFloorid(h3cUpAp.getFloorId());
                            locationLatest.setInDoor(h3cUpAp.getInDoor());
                            locationLatest.setInSchool(1);
                            locationLatest.setLocationTime(new Date());
                            locationLatest.setLocationMode("2");
                            //增加校区ID
                            locationLatest.setZoneId(h3cUpAp.getZoneId());

                            locationLatestService.update(locationLatest);
                        }
                    }
                }
            }

            get.releaseConnection();
            client.getHttpConnectionManager().closeIdleConnections(0L);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void initMap(){
        List<H3cUpAp> apList = null;
        if(LOCATION_AP_MAP.keySet().size() == 0){
            apList = h3cUpApService.getAll();
        } else {
            apList = h3cUpApService.selectNewData();
        }

        for(H3cUpAp h3cUpAp : apList){
            if(h3cUpAp.getFloorId() == null || h3cUpAp.getLng() == null || h3cUpAp.getLat() == null){
                //通过cmgis接口调用获取数据
                MapInfoVO mapInfoVO = mapService.queryFloorCenterLngLat(h3cUpAp.getCampusName(), h3cUpAp.getBuildingName(), h3cUpAp.getRoomName());
                if(mapInfoVO != null){
                        h3cUpAp.setFloorId(mapInfoVO.getLevel());
                        h3cUpAp.setLng(mapInfoVO.getCenter().getX());
                        h3cUpAp.setLat(mapInfoVO.getCenter().getY());
                        //增加校区信息
                        h3cUpAp.setZoneId(mapInfoVO.getZoneId());
                        h3cUpApService.update(h3cUpAp);
                } else{
                    System.out.println(h3cUpAp.getApCode() + ":找不到对应房间");
                }
            } else{
                LOCATION_AP_MAP.put(h3cUpAp.getApCode(), h3cUpAp);
            }
        }
    }

    public H3cUpConfig getH3cUpConfig() {
        return h3cUpConfig;
    }

    public void setH3cUpConfig(H3cUpConfig h3cUpConfig) {
        this.h3cUpConfig = h3cUpConfig;
    }
}
