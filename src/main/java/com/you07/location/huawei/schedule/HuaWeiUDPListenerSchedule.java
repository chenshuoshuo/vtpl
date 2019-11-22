package com.you07.location.huawei.schedule;

import com.you07.location.huawei.model.HwAp;
import com.you07.location.huawei.service.HwApService;
import com.you07.map.service.MapService;
import com.you07.map.vo.MapInfoVO;
import com.you07.vtpl.model.LocationLatest;
import com.you07.vtpl.service.LocationLatestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;
import java.util.List;

/**
 * 华为AP对接服务
 *
 * @author lh
 * @since 2018-12-11
 */
@Component
public class HuaWeiUDPListenerSchedule {

    @Autowired
    private HwApService hwApService;
    @Autowired
    private MapService mapService;
    @Autowired
    private LocationLatestService locationLatestService;

    private DatagramSocket serverSocket = null;
    private Integer udpPort;

    public HuaWeiUDPListenerSchedule() {
    }

    public HuaWeiUDPListenerSchedule(Integer udpPort) {
        this.udpPort = udpPort;
    }

    /**
     * 启动任务
     */
    public void startJob() {
        if (serverSocket == null) {
            updateHwAp();
            startHwUDPListener();
        } else {
            System.out.println("HuaWei-Ap UDP server is listenning...");
        }
    }

    public void startHwUDPListener() {
        try {
            serverSocket = new DatagramSocket(udpPort);
            byte[] receiveData = new byte[1024];
            System.out.println("start HuaWei-Ap UDP server");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String data = new String(receivePacket.getData(), 0, receivePacket.getLength());
                //System.out.println("data:" + data);
                String apMac = getFieldValue(receiveData, 3, 6, "mac");//帐户上报AP 的MAC 地址
                String zdMac = getFieldValue(receiveData, 14, 6, "mac");//WIFI终端的MAC地址
                System.out.println("===================");
                System.out.println("zdMac is :"+zdMac);
                System.out.println("===================");
                System.out.println("===================");
                System.out.println("apMac is :"+apMac);
                System.out.println("===================");
                LocationLatest ll=locationLatestService.loadByAccountMac(zdMac);
                HwAp hwAp=hwApService.selectHwapByMac(apMac);
                try {
                    if(ll != null && hwAp !=null){
                        ll.setLng(hwAp.getLng());
                        ll.setLat(hwAp.getLat());
                        ll.setFloorid(hwAp.getFloorid());
                        ll.setInDoor(hwAp.getIndoor());
                        ll.setLocationTime(new Date());
                        ll.setInSchool(1);
                        ll.setLocationMode("1");
                        locationLatestService.update(ll);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHwAp() {
//        System.out.println("start updateHwAp....");
        List<HwAp> hwAps = hwApService.selectNewData();
        for (HwAp hwAp : hwAps) {
//            System.out.println("start for ....");
            MapInfoVO mapInfoVO = mapService.queryFloorCenterLngLat(hwAp.getCampus(), hwAp.getBuilding(), hwAp.getRoom());
//            System.out.println("===================");
//            System.out.println(rommInfo);
//            System.out.println("===================");
            if (mapInfoVO != null && mapInfoVO.getCenter() != null) {
//                System.out.println("start if rommInfo != null ....");
//                    System.out.println("start if roomInfoArray.length == 3 ....");
                    hwApService.updataHwAp(mapInfoVO.getCenter().getX(), mapInfoVO.getCenter().getY(), hwAp.getDeviceMac(),hwAp.getZoneId());
            } else {
                throw new RuntimeException("can't find the room");
            }
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
