package com.you07.cas.shenlan.util;

import java.util.ArrayList;
import java.util.List;

public class TlvTools {
    public List<Tlv> tlvList;

    public TlvTools() {
        tlvList = new ArrayList<Tlv>();
    }

    public List<Tlv> unpack(byte[] data) {
        int current = 0;//遍历数据标签
        int lenValue = 0;//L的值
        int tagLen = 1;//tag的长度
        int length = 1;
        while (current < data.length) {
            Tlv tlvData = new Tlv();

            //获取tag值，并转成int
            tlvData.setTag(getTagToInt(data, current, tagLen));
            current++;
            //获取length值，并转成int
            lenValue = getTagToInt(data, current, length);
            tlvData.setLen(lenValue);

            //设置value值
            byte[] temp = new byte[lenValue - 2];
            System.arraycopy(data, current + 1, temp, 0, lenValue - 2);
            tlvData.setValue(temp);
            current += lenValue - 1;
            tlvList.add(tlvData);
        }

        return tlvList;
    }

    //hex数据转换成byte
    public byte[] hexStrToBytes(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        int len = data.length() / 2;
        byte[] result = new byte[len];

        //将每个char字符单独转换成byte数据
        char[] chArr = data.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(chArr[pos]) << 4 | toByte(chArr[pos + 1]));
        }
        return result;
    }

    //获取tag长度
    public int getTagLen(byte[] data, int flag) {
        /*若tag标签的第一个字节（注：字节排序方向为从左往右数，
         * 第一个字节即为最左边的字节。bit排序规则同理。）的后
         * 四个bit为“1111”，则说明该tag占两个字节，例如“9F33”；
         * 否则占一个字节，例如“95”。*/
        int tagLen = 1;
        for (int i = 0; i < 2; i++) {
            byte b = data[i + flag];
            if ((b & 0x0F) == 0x0F) {
                tagLen++;
            } else {
                break;
            }
        }
        return tagLen;
    }

    public static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    //获取tag，并转成int
    public int getTagToInt(byte[] data, int flag, int len) {
        int mask = 0xFF;
        int temp = 0;
        int result = 0;
        len = Math.min(len, 4);//tag最长4位
        for (int i = 0; i < len; i++) {
            result <<= 8;//向左位移8
            temp = data[flag + i] & mask;
            result |= temp;//将获取出的数据填充到result让出右侧的8位上
        }
        return result;
    }

    private static char[] HEX_VOCABLE = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    //bytes数组转换成string
    public static String bytesToHex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            //获取高4位的数据值，正好对应HEX_VOCABLE数组中的下标，和相应char的值
            int high = (b >> 4) & 0x0f;
            //获取低4位的数据值，正好对应HEX_VOCABLE数组中的下标，和相应char的值
            int low = b & 0x0f;
            sb.append(HEX_VOCABLE[high]);
            sb.append(HEX_VOCABLE[low]);
        }
        return sb.toString();
    }

}
