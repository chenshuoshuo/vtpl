package com.you07.location.h3cap.schedule;

import com.you07.location.h3cap.config.H3cApConfig;
import com.you07.location.h3cap.model.H3cView;
import com.you07.location.h3cap.service.H3cViewService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
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

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时更新位置视图信息
 * @author RY
 *
 */
@Component
public class H3cViewUpdateSchedule implements java.io.Serializable{

	@Autowired
	private H3cViewService h3cViewService;
	private Map<String, H3cView> viewMap = new HashMap<String, H3cView>();
	private H3cApConfig h3cApConfig;
	private HttpClient client = null;
	private GetMethod get = null;

	public H3cViewUpdateSchedule(H3cApConfig h3cApConfig){
		this.h3cApConfig = h3cApConfig;
	}

	public void updateH3cViewSchedule(){

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
                client.getHostConfiguration().setHost(h3cApConfig.getHost(), h3cApConfig.getPort());
                client.getState().setCredentials(
                    new AuthScope(h3cApConfig.getHost(), h3cApConfig.getPort(), "iMC RESTful Web Services"),
                    new UsernamePasswordCredentials(h3cApConfig.getUsr(), h3cApConfig.getPwd()));
            }


			get = new GetMethod("/imcrs/wlan/locationInfo/queryLocationInfo");
			get.addRequestHeader("accept", "application/xml");
//    	get.setRequestHeader("charset", "UTF-8");
			client.executeMethod(get);
			String responseData = get.getResponseBodyAsString();
			if(responseData != null && !"".equals(responseData)){
                responseData = new String(responseData.getBytes("ISO-8859-1"), "UTF-8");
    //            System.out.println(responseData);

                Document document = DocumentHelper.parseText(responseData);
                Element root = document.getRootElement();
                List<Element> listElement=root.elements();
                for(Element e : listElement){
                    readElement(e);
                }
            }


			get.releaseConnection();
			client.getHttpConnectionManager().closeIdleConnections(0L);
			saveMap();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	//遍历当前节点下的所有节点  
    public void readElement(Element node) throws HttpException, IOException, DocumentException{  
    	H3cView view = new H3cView();

    	String viewName = node.elementText("name");

    	if(viewMap.containsKey(viewName)){
    		view = viewMap.get(viewName);
    	} else{
    		view.setViewName(viewName);
    	}


    	Integer level = Integer.parseInt(node.elementText("level"));
    	Integer subLocationCount = Integer.parseInt(node.elementText("subLocationCount"));

    	view.setLevel(level);
    	view.setSubLocationCount(subLocationCount);
//    	System.out.println("load scale start :" + viewName);
    	get = new GetMethod("/imcrs/wlan/loc/getScaleByLocName");
    	get.addRequestHeader("accept", "application/xml");
//    	get.setRequestHeader("charset", "UTF-8");
    	get.setQueryString(new NameValuePair[] {new NameValuePair("locName", viewName)});
    	client.executeMethod(get);
    	String responseData = get.getResponseBodyAsString();
        if(responseData != null && !"".equals(responseData)){
        	responseData = new String(responseData.getBytes("ISO-8859-1"), "UTF-8");
	        Document scaleDocument = DocumentHelper.parseText(responseData);
	        Element rootElement = scaleDocument.getRootElement();
	        Element scaleElement = rootElement.element("scale");
	        Double scale = Double.parseDouble(scaleElement.elementText("scale"));
	        Integer scaleType = Integer.parseInt(scaleElement.elementText("scaleType"));

	        view.setScale(scale);
	        view.setScaleType(scaleType);
	        viewMap.put(view.getViewName(), view);
        }

        if(subLocationCount != 0){
        	List<Element> childList = node.elements("subLocationList");
        	for(Element child : childList){
        		readElement(child);
        	}
        }
    } 
    
    public void initMap(){
    	viewMap.clear();
    	List<H3cView> list = h3cViewService.queryAll();
    	for(H3cView view : list){
    		viewMap.put(view.getViewName(), view);
    	}
    }
    
    public void saveMap(){
    	for(H3cView view : viewMap.values()){
    		if(view.getScale() != null && view.getScale() != 0){
				h3cViewService.update(view);
			}
    	}
    }

	public H3cApConfig getH3cApConfig() {
		return h3cApConfig;
	}

	public void setH3cApConfig(H3cApConfig h3cApConfig) {
		this.h3cApConfig = h3cApConfig;
	}
}
