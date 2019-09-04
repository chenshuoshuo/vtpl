package com.you07.location.h3cap.schedule;

import com.you07.location.h3cap.config.H3cApConfig;
import com.you07.location.h3cap.model.H3cView;
import com.you07.location.h3cap.service.H3cViewService;
import com.you07.vtpl.model.LocationLatest;
import com.you07.vtpl.service.LocationLatestService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.osgeo.proj4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时更新用户位置信息
 * @author RY
 *
 */
@Component
public class H3cApLocationSchedule implements java.io.Serializable{

	@Autowired
	private H3cViewService h3cViewService;
	@Autowired
	private LocationLatestService locationLatestService;
	private Map<String, H3cView> viewMap = new HashMap<String, H3cView>();
	
	private HttpClient client = null;
	private GetMethod get = null;
	private H3cApConfig h3cApConfig;

	public H3cApLocationSchedule(H3cApConfig h3cApConfig){
		this.h3cApConfig = h3cApConfig;
	}

	public void updateH3cLocationSchedule(){
		System.out.println("h3c-ap-location start !!!");
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


			get = new GetMethod("/imcrs/wlan/loc/getAllLocation");
			get.addRequestHeader("accept", "application/xml");
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
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 遍历XML节点
	 * 进行位置信息存储
	 * @param node
	 * @throws HttpException
	 * @throws IOException
	 * @throws DocumentException
	 */
    public void readElement(Element node) throws HttpException, IOException, DocumentException{  
    	
    	String mac = node.elementText("macAddress");
//    	System.out.println(mac);
    	if(mac != null){
    		mac = mac.replaceAll(":", "").toLowerCase();
    	}
//    	System.out.println(mac);
    	LocationLatest location = locationLatestService.loadByAccountMac(mac);
    	if(mac != null && !"".equals(mac) && location != null){
    		String viewName = node.elementText("locName");
//    		System.out.println(viewName);
    		H3cView view = viewMap.get(viewName);
    		Double posX = Double.parseDouble(node.elementText("posX"));
    		Double posY = Double.parseDouble(node.elementText("posY"));
    		if(view != null && view.getLon() != null && view.getLat() != null && view.getScale() != null && view.getScaleType() != null){
//    			System.out.println(view.getViewId());
    			// 从位置视图获取原点经纬度
    			Double originLon = view.getLon();
    			Double originLat = view.getLat();
    			
    			// 把原点经纬度转换成UMT投影坐标
    			Double[] originUmtArray = transformProjection(originLon, originLat, "epsg:4326", "epsg:3857");
    			Double originLonUmt = originUmtArray[0];
    			Double originLatUmt = originUmtArray[1];
    			
    			// 根据比例尺计算定位位置的UMT投影坐标
    			// 比例尺类型为0代表比例尺单位：米，否则为英尺
    			Double locationLonUmt;
    			Double locationLatUmt;
    			if(view.getScaleType() == 0){
    				locationLonUmt = originLonUmt + (posX * view.getScale() / 100);
    				locationLatUmt = originLatUmt - (posY * view.getScale() / 100);
    			} else{
    				locationLonUmt = originLonUmt + (posX * view.getScale() * 0.305 / 100);
    				locationLatUmt = originLatUmt - (posY * view.getScale() * 0.305 / 100);
    			}
    			
    			// 把定位位置的UMT投影坐标转回经纬度
    			// 保存进用户位置信息
    			Double[] locationArray = transformProjection(locationLonUmt, locationLatUmt, "epsg:3857", "epsg:4326");
//    			System.out.println("h3c_view:" + view.getViewId() + "," + view.getViewName());
//    			System.out.println("mac:" + mac);
//    			System.out.println("originLonLat:" + originLon + "," + originLat);
//    			System.out.println("originLonLatUmt:" + originLonUmt + "," + originLatUmt);
//    			System.out.println("scale:" + view.getScale() + "," + view.getScaleType());
//    			System.out.println("posXY:" + posX + "," + posY);
//    			System.out.println("locationLonLatUmt:" + locationLonUmt + "," + locationLatUmt);
//    			System.out.println("locationLonLat:" + locationArray[0] + "," + locationArray[1]);
    			
    			location.setLng(locationArray[0]);
    			location.setLat(locationArray[1]);
    			location.setFloorid(view.getFloorid());
    			location.setLocationMode("3");
    			location.setInDoor(view.getInDoor());
    			location.setInSchool(1);
    			//设置校区ID
				location.setZoneId(view.getZoneId());
    			location.setLocationTime(new Date());
    			locationLatestService.update(location);
    		}
    	}
    	
        
    } 
    
    /**
     * 初始化位置视图MAP
     */
    public void initMap(){
    	viewMap.clear();
    	List<H3cView> list = h3cViewService.queryAll();
    	for(H3cView view : list){
    		viewMap.put(view.getViewName(), view);
    	}
    }
    
    /**
     * epsg:4326 经纬度
     * epsg:32649 UTM投影
     * 
     * 
     * 经纬度与UTM投影坐标进行转换
     * @param lon
     * @param lat
     * @return
     */
    public Double[] transformProjection(Double lon, Double lat, String srcSystemName, String distSystemName){
    	Double[] projectionArray=new Double[]{0.0,0.0};
    	
    	CoordinateReferenceSystem srcSystem;
        CoordinateReferenceSystem distSystem;

        CRSFactory crsFactory=new CRSFactory();

        srcSystem=crsFactory.createFromName(srcSystemName);
        distSystem=crsFactory.createFromName(distSystemName);

        ProjCoordinate srcCoordinate=new ProjCoordinate();
        ProjCoordinate distCoordinate=new ProjCoordinate();

        srcCoordinate.setValue(lon, lat);
       

        CoordinateTransform transform = new CoordinateTransformFactory().createTransform(srcSystem,distSystem);
        transform.transform(srcCoordinate,distCoordinate);
        
        projectionArray[0] = distCoordinate.x;
        projectionArray[1] = distCoordinate.y;
        
        return projectionArray;
    }

	public H3cApConfig getH3cApConfig() {
		return h3cApConfig;
	}

	public void setH3cApConfig(H3cApConfig h3cApConfig) {
		this.h3cApConfig = h3cApConfig;
	}
}
