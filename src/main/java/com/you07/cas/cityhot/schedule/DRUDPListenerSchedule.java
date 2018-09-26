package com.you07.cas.cityhot.schedule;

import com.you07.vtpl.service.LocationLatestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 城市热点身份认证对接服务
 * @author RY
 * @since 2018-8-6 11:24:50
 */
@Component
public class DRUDPListenerSchedule{

	@Autowired
	private LocationLatestService locationLatestService;
	private DatagramSocket serverSocket = null;
	private Integer udpPort;

	public DRUDPListenerSchedule(){};

	public DRUDPListenerSchedule(Integer udpPort){
		this.udpPort = udpPort;
	}

	/**
	 * 启动任务
	 */
	public void startJob(){
		System.out.println("start DRUDP server");
		if(serverSocket == null){
			startDRUDPListener();
		} else{
			System.out.println("drdup is listenning...");
		}
	}
	
	public void startDRUDPListener(){
		try {
			serverSocket = new DatagramSocket(udpPort);
			byte[] receiveData = new byte[1024];
			System.out.println("start udp server...");
			while(true){
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				serverSocket.receive(receivePacket);
//				String sentence = new String( receivePacket.getData());
				InetAddress IPAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();
//				String sTime=getFieldValue(receiveData,12,20,"string");//事件发生时间
				String sAccount=getFieldValue(receiveData,32,32,"string");//帐户id
//				String sGroup=getFieldValue(receiveData,212,2,"short");//计费组id
				String sType=getFieldValue(receiveData,226,1,"byte");//事件类型，1登录，2离线，3在线
//				String sIP=getFieldValue(receiveData,227,4,"ip");//ip
				String sMAC=getFieldValue(receiveData,231,6,"mac");//mac
				String mode = "";
//				System.out.println("sAccount:" + sAccount + ",sType:" + sType + ",sMac:" + sMAC);
				
				// 不处理下线
				if(Integer.parseInt(sType) != 2){
					if(sAccount != null && !"".equals(sAccount.trim()) && sMAC != null && !"".equals(sMAC.trim())){
						if(sAccount.indexOf("@") != -1){
							mode = sAccount.substring(sAccount.indexOf("@") + 1);
							sAccount = sAccount.substring(0, sAccount.indexOf("@"));
			    	    }
			    	    try {
							locationLatestService.saveUser(sAccount.trim(), sMAC.trim(), mode);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							continue;
						}
			        }
			     }
				
				byte[] sendData = {0, 0, 0, (byte)0x80, 0, 0, 0, 0};
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
				serverSocket.send(sendPacket);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    private String getFieldValue(byte[] bty, int srcPosition, int length, String converFlag) throws Exception {
        byte[] temp = new byte[length];  
        String returnStr = "";  
        System.arraycopy(bty, srcPosition, temp, 0, length);  
        if ("".equals(converFlag) || "string".equals(converFlag)) {  
            int position = 0;  
             for (int i = temp.length - 1; i >= 0; i--) {  
                position = i;  
                if (temp[i] != 0){
                	break;
				}
            }  
            byte[] validValue = new byte[position + 1];  
            System.arraycopy(temp, 0, validValue, 0, position + 1);  
            returnStr = new String(validValue);  
        } else if ("integer".equals(converFlag)) {  
            //returnStr = String.valueOf(ByteConvert.lBytesToInt(temp));  
        } else if ("short".equals(converFlag)) {  
        	returnStr=String.valueOf((int)temp[0]+temp[1]*256);
        } else if ("byte".equals(converFlag)) {  
        	returnStr=String.valueOf((int)temp[0]);
        }else if ("ip".equals(converFlag)) {  
        	returnStr=String.valueOf(temp[0]&0xff)+"."+String.valueOf(temp[1]&0xff)+"."+String.valueOf(temp[2]&0xff)+"."+String.valueOf(temp[3]&0xff)+".";
        }else if ("mac".equals(converFlag)) {  
        	for (int i=0; i < temp.length; i++) {
						returnStr += Integer.toString( ( temp[i] & 0xff ) + 0x100, 16).substring( 1 );
					}
				}
          
        return returnStr;  
    }
    
    public static void main(String[] args) {
		String str = "123456@sd";
		System.out.println(str.substring(0, str.indexOf("@")));
		System.out.println(str.substring(str.indexOf("@") + 1));
	}

	public Integer getUdpPort() {
		return udpPort;
	}

	public void setUdpPort(Integer udpPort) {
		this.udpPort = udpPort;
	}
}
