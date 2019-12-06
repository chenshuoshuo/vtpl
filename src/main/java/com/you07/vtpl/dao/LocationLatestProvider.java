package com.you07.vtpl.dao;

import com.you07.vtpl.model.LocationLatest;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @author egan
 * @date 2019/12/6 10:57
 * @desc
 */
public class LocationLatestProvider {
    public static final String TABLE_NAME = "location_latest";
    public String insertBatch(List<LocationLatest> locationLatests){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(TABLE_NAME).append(" ");
        sb.append("VALUES ");
        MessageFormat mf = new MessageFormat(
                "(#'{'list[{0}].userid}," +
                        "#'{'list[{0}].realname}," +
                        "#'{'list[{0}].accountId}," +
                        "#'{'list[{0}].gender}," +
                        "#'{'list[{0}].accountMac}," +
                        "#'{'list[{0}].orgCode}," +
                        "#'{'list[{0}].orgName}," +
                        "#'{'list[{0}].lng}," +
                        "#'{'list[{0}].lat}," +
                        "#'{'list[{0}].floorid}," +
                        "#'{'list[{0}].locationTime}," +
                        "#'{'list[{0}].usrUpdateTime}," +
                        "#'{'list[{0}].locationMode}," +
                        "#'{'list[{0}].inDoor}," +
                        "#'{'list[{0}].inSchool}," +
                        "#'{'list[{0}].zoneId}," +
                        "#'{'list[{0}].telephone})");
        for (int i = 0; i < locationLatests.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < locationLatests.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
