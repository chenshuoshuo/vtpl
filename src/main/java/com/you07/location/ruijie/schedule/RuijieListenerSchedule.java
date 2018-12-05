package com.you07.location.ruijie.schedule;

import com.you07.location.ruijie.model.LocationViewRuijie;
import com.you07.location.ruijie.service.LocationViewRuijieService;
import com.you07.vtpl.model.LocationLatest;
import com.you07.vtpl.service.LocationLatestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 定位信息服务器
 * @author RY
 * @version 1.0
 * @since 2018-8-06 09:50:08
 */
@Component
public class RuijieListenerSchedule{
	@Autowired
	private LocationLatestService locationLatestService;
	@Autowired
	private LocationViewRuijieService locationViewRuijieService;
	private static Map<Integer, LocationViewRuijie> LOCATION_VIEW_MAP = new HashMap<Integer, LocationViewRuijie>();
	ServerSocket ss = null;
	private Integer sockePort;

	public RuijieListenerSchedule(){};

	public RuijieListenerSchedule(Integer sockePort){
		this.sockePort = sockePort;
	}

	/**
	 * 启动任务
	 */
	public void startJob(){
		System.out.println("start Ruijie udp server:" + sockePort);
		if(ss == null){
			startRuijieListener();
		} else {
			System.out.println("ruijie udp is listening...");
		}
	}
	
	public void startRuijieListener(){
		try {
			
			initViewMap();
			
			ss = new ServerSocket(sockePort);
			Socket client = null;
//			System.out.println("Tcp定位数据服务器启动");
			while (true) {
				client = ss.accept();
				InputStream in = client.getInputStream();
				DataInputStream ins = new DataInputStream(in);
				byte[] buff = new byte[1024];
				ByteBuffer buffer = ByteBuffer.allocateDirect(2048);
				int len = 0;
				while ((len = ins.read(buff)) != -1) {
					buffer.put(buff, 0, len);
					try {
						processData(buffer);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						continue;
					}
				}// 循环读取数据
				if (in != null){
					in.close();
				}
				if (client != null){
					client.close();
				}
			}   // 循环获取连接
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	// 进来之前保证都是写模式
	private void processData(ByteBuffer buffer) {
		// 数据量小于4，不能确定是否包含标识符
		if (buffer.position() < 4) {
			// 接着上次位置接受数据
			return;
		}
		// 数数据量大于4时,切换到读模式
		buffer.flip();
		byte[] src = new byte[buffer.limit()];
		buffer.get(src);
		// 获取标识符位置
		int startPos = getFirstApLocationStartPos(src);
		if (startPos < 0) 
		{
			// 不包含标识符，则清空缓存,切换到写模式
			buffer.clear();
			return;
		} 
		else if (startPos > 0)
		{
			// 包含标识符，但不在起始位置
			// 则清理起始位置前的数据,切换到写模式，重新进入本函数，
			buffer.clear();
			buffer.put(src, startPos, src.length - startPos);
			processData(buffer);
		}
		else if (startPos == 0) 
		{
			// 包含标识符，并且就在起始位置,重置读得起点，开始提取数据
			buffer.rewind();
			src = new byte[buffer.limit()];
			buffer.get(src);
			int dataLen = getApLocationDataLength(src);
			if (src.length < dataLen) {
				// 数据不足,保存当前并继续接收
				buffer.clear();
				buffer.put(src);
				return;
			} else if (src.length == dataLen) {
				byte[] data = new byte[dataLen];
				System.arraycopy(src, 0, data, 0, dataLen);
				initDataFromBytes(data);
				buffer.clear();
			} else if (src.length > dataLen) {
				// 如果接收完毕，就处理数据
				byte[] data = new byte[dataLen];
				System.arraycopy(src, 0, data, 0, dataLen);
//                System.out.println("initDataFormBytes::"+data.length);
				initDataFromBytes(data);
				// 缓存剩下的数据，重新进入函数
				buffer.clear();
				buffer.put(src, dataLen, src.length - dataLen);
				processData(buffer);
			}
		}
	}
	
	private static int getFirstApLocationStartPos(byte[] buff) {
		if (buff.length < 2){
			return -2;
		}
		for (int i = 0; i < buff.length - 1; i++) {
			if (buff[i] == (byte) 0x7b && buff[i + 1] == (byte) 0x81) {
				return i;
			}
		}
		return -1;
	}
	
	private static int getApLocationDataLength(byte[] buff) {
		return byteArrayToShort(new byte[] { buff[2],
				buff[3] });
	}
	
	public void initDataFromBytes(byte[] data) {
		if (data == null || data.length < 51) {
			return;
		}
		if (data[0] != (byte) 0x7b || data[1] != (byte) 0x81) {
			return;
		}
		short len = byteArrayToShort(new byte[] { data[2], data[3] });
		if (len != data.length) {
			return;
		}
		
		byte[] temp = newByteArray(data, 16, 6);
		String mac = byteArrayToHexString(temp);
//		System.out.println("mac:" + mac);
		LocationLatest ll = locationLatestService.loadByAccountMac(mac);
		if(ll != null){
			temp = newByteArray(data, 4, 4);
			Integer ruijieFloorid = byteArrayToInt(temp);

			LocationViewRuijie lvr = LOCATION_VIEW_MAP.get(ruijieFloorid);
			if(lvr != null){
				temp = newByteArray(data, 30, 4);
				Float x = byteArrayToFloat(temp);
				temp = newByteArray(data, 34, 4);
				Float y = byteArrayToFloat(temp);

				double[] lonlat = transformCoordinateToLongLat(x, y, lvr);
				ll.setLng(lonlat[0]);
				ll.setLat(lonlat[1]);
				ll.setFloorid(lvr.getFlooridLq());
				temp = newByteArray(data, 22, 8);
				ll.setLocationTime(new Date(byteArrayToLong(temp)));
				ll.setInDoor(lvr.getInDoor());
				ll.setInSchool(1);
				ll.setLocationMode("1");
//                System.out.println("updateLL:"+ll.getRealname()+ll.getLat()+"lng:"+ll.getLng());
				locationLatestService.update(ll);
			}
		}
		
		
	}
	
	private static byte[] newByteArray(byte[] datas, int start, int len) {
		if (datas == null || start < 0 || len < 0 || datas.length < start + len) {
			return null;
		}
		byte[] ret = new byte[len];
		for (int i = start; i < start + len; i++) {
			ret[i - start] = datas[i];
		}
		return ret;
	}
	
	private static long byteArrayToLong(byte[] bytes) {
		if (bytes == null || bytes.length != 8) {
			return 0;
		}
		ByteBuffer buff = ByteBuffer.allocate(8);
		buff.order(ByteOrder.BIG_ENDIAN);
		buff.put(bytes);
		buff.flip();
		long ret = buff.getLong();
		buff.clear();
		return ret;
	}

	public static short byteArrayToShort(byte[] bytes) {
		if (bytes == null || bytes.length != 2) {
			return 0;
		}
		ByteBuffer buff = ByteBuffer.allocate(2);
		buff.order(ByteOrder.BIG_ENDIAN);
		buff.put(bytes);
		buff.flip();
		short ret = buff.getShort();
		buff.clear();
		return ret;
	}

	private static int byteArrayToInt(byte[] bytes) {
		if (bytes == null || bytes.length != 4) {
			return 0;
		}
		ByteBuffer buff = ByteBuffer.allocate(4);
		buff.order(ByteOrder.BIG_ENDIAN);
		buff.put(bytes);
		buff.flip();
		int ret = buff.getInt();
		buff.clear();
		return ret;
	}

	private static float byteArrayToFloat(byte[] bytes) {
		if (bytes == null || bytes.length != 4) {
			return 0;
		}
		ByteBuffer buff = ByteBuffer.allocate(4);
		buff.order(ByteOrder.BIG_ENDIAN);
		buff.put(bytes);
		buff.flip();
		float ret = buff.getFloat();
		buff.clear();
		return ret;
	}

	private static String byteArrayToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString().trim();
	}
	
	/**
	 * 锐捷定位标准：
	 * 左上（0,0），右下（1,1）
	 * 计算方式为：
	 * 实际经度  = 左上经度  + （右下经度 - 左上经度）* 锐捷坐标x
	 * 实际纬度 = 左上纬度 - （左上纬度 - 右下纬度） * 锐捷坐标y
	 * @param x
	 * @param y
	 * @param lvr
	 * @return
	 */
	public double[] transformCoordinateToLongLat(float x, float y, LocationViewRuijie lvr) {
		double longitude, latitude;
		longitude = lvr.getLeftTopLon() + (lvr.getRightDownLon() - lvr.getLeftTopLon()) * x;
		latitude = lvr.getLeftTopLat() - (lvr.getLeftTopLat() - lvr.getRightDownLat()) * y;
		return new double[] { longitude, latitude };
	}
	
	public void initViewMap(){
		if(LOCATION_VIEW_MAP.keySet().size() == 0){
			List<LocationViewRuijie> lvrList = locationViewRuijieService.listAll();
			for(LocationViewRuijie lvr : lvrList){
				LOCATION_VIEW_MAP.put(lvr.getFlooridRuijie(), lvr);
			}
		}
	}

	public Integer getSockePort() {
		return sockePort;
	}

	public void setSockePort(Integer sockePort) {
		this.sockePort = sockePort;
	}
}
