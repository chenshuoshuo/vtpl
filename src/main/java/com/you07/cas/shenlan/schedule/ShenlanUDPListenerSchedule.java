package com.you07.cas.shenlan.schedule;

import com.you07.cas.shenlan.util.Tlv;
import com.you07.cas.shenlan.util.TlvTools;
import com.you07.vtpl.service.LocationLatestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 深澜身份认证对接服务
 *
 * @author ZQ
 * @since 2018-12-6 14:16:18
 */
@Component
public class ShenlanUDPListenerSchedule {

    @Autowired
    private LocationLatestService locationLatestService;
    private DatagramSocket serverSocket = null;
    private Integer udpPort;

    public ShenlanUDPListenerSchedule() {
    }

    ;

    public ShenlanUDPListenerSchedule(Integer udpPort) {
        this.udpPort = udpPort;
    }

    /**
     * 启动任务
     */
    public void startJob() {
        System.out.println("start shenlanUDP server");
        if (serverSocket == null) {
            startShenlanUDPListener();
        } else {
            System.out.println("shenlandup is listenning...");
        }
    }

    public void startShenlanUDPListener() {
        try {
            System.out.println(udpPort);
            //绑定端口
            serverSocket = new DatagramSocket(udpPort);
            byte[] receiveData = new byte[1024];
            System.out.println("start udp server...");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                int length= receivePacket.getLength();
                System.out.println(length);
                // 去除空和包头
                byte[] temp = new byte[length-20];
                System.arraycopy(receiveData, 20, temp, 0, length-20);
                TlvTools tlvTools = new TlvTools();
                tlvTools.unpack(temp);
                String mac="";
                String name="";
                String mode="";
                for (int i = 0; i < tlvTools.tlvList.size(); i++) {
                    Tlv tlv = tlvTools.tlvList.get(i);
                    if (tlv.getTag() == 31) {
                         mac = getFieldValue(tlv.getValue(), 0, tlv.getLen() - 2, "string");
                        System.out.println("mac: " + mac);
                    } else if (tlv.getTag() == 1) {
                         name = getFieldValue(tlv.getValue(), 0, tlv.getLen() - 2, "string");
                        System.out.println("name: " + name);
                    }

                }
                String realMac="";
                for (int i = 0; i < mac.length(); i++) {
                    if(mac.charAt(i) != '-'){
                        realMac += mac.charAt(i);
                    }
                }
                System.out.println("realMac is "+ realMac);
                String lowerRealMac=realMac.replace(":","").toLowerCase();
                System.out.println("lowerRealMac is "+ lowerRealMac);
                System.out.println("start data insert");
                try {
                    locationLatestService.saveUser(name,lowerRealMac,mode);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        serverSocket.close();
    }

    private String getFieldValue(byte[] bty, int srcPosition, int length, String converFlag) throws Exception {
        byte[] temp = new byte[length];
        String returnStr = "";
        System.arraycopy(bty, srcPosition, temp, 0, length);
        if ("".equals(converFlag) || "string".equals(converFlag)) {
            int position = 0;
            for (int i = temp.length - 1; i >= 0; i--) {
                position = i;
                if (temp[i] != 0) {
                    break;
                }
            }
            byte[] validValue = new byte[position + 1];
            System.arraycopy(temp, 0, validValue, 0, position + 1);
            returnStr = new String(validValue);
        } else if ("integer".equals(converFlag)) {
            //returnStr = String.valueOf(ByteConvert.lBytesToInt(temp));
        } else if ("short".equals(converFlag)) {
            returnStr = String.valueOf((int) temp[0] + temp[1] * 256);
        } else if ("byte".equals(converFlag)) {
            returnStr = String.valueOf((int) temp[0]);
        } else if ("ip".equals(converFlag)) {
            returnStr = String.valueOf(temp[0] & 0xff) + "." + String.valueOf(temp[1] & 0xff) + "." + String.valueOf(temp[2] & 0xff) + "." + String.valueOf(temp[3] & 0xff) + ".";
        } else if ("mac".equals(converFlag)) {
            for (int i = 0; i < temp.length; i++) {
                returnStr += Integer.toString((temp[i] & 0xff) + 0x100, 16).substring(1);
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