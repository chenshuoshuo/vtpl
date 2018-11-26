package com.you07.cas.ruijie.schedule;


import com.you07.cas.ruijie.config.RuijieCasConfig;
import com.you07.client.*;
import com.you07.util.StringUtil;
import com.you07.vtpl.model.LocationLatest;
import com.you07.vtpl.service.LocationLatestService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 更新用户信息定时任务
 * @author ZJ
 *
 */
@Component
public class RuijieUpdateUserMacSchedule implements java.io.Serializable{

	private static final long serialVersionUID = -8474358365679858208L;
	@Resource
	private LocationLatestService locationLatestService;

	private RuijieCasConfig ruijieCasConfig;
	/**
	 * 启动任务
	 */
	public void startJob(){
		System.out.println("start update usr-mac");
		updateUserMac();
	}
	
	public void updateUserMac(){
		Boolean hasNextPage = true;// 定义是否还有下一页
		Integer page = 1;// 当前请求的页码
		Integer pageSize = 200;// 每页请求的数据条数，最大只支持200

		SamServicePortType samServicePortType = new SamService().getSamServicePort();
		if(samServicePortType == null){
			System.out.println("SAM服务器为null");
			return;
		}
		while(hasNextPage){
			try {
				QueryOnlineUserParam param = new QueryOnlineUserParam();
				param.setNasIp("10.18.0.9");
				param.setOffSet((page - 1 ) * pageSize);
				param.setLimit(pageSize);
				QueryOnlineUserResult queryOnlineUserResult = samServicePortType.queryOnlineUser(param);

				if(queryOnlineUserResult == null){
                    return;
                }
				List<OnlineUserInfo> onlineUserInfoList = queryOnlineUserResult.getOnlineUserInfos();
//				System.out.println("page:" + page + ", list-size:" + onlineUserInfoList.size());
				if(onlineUserInfoList == null || onlineUserInfoList.size() == 0){
                    hasNextPage = false;
                    break;
                } else{
                    for(OnlineUserInfo onlineUserInfo : onlineUserInfoList){
                        String accountId = onlineUserInfo.getAccountId();
                        String mac = onlineUserInfo.getUserMac();
                        if(StringUtil.isNotEmpty(accountId) && StringUtil.isNotEmpty(mac)){
                            accountId = accountId.toLowerCase();
                            mac = mac.toLowerCase();
                            locationLatestService.invalidMac(mac);
                            LocationLatest locationLatest = locationLatestService.getByAccountId(accountId);
                            if(locationLatest != null){
                                locationLatest.setAccountMac(mac);
                                locationLatestService.update(locationLatest);
                            } else{
                                locationLatestService.saveUser(accountId,mac,null);
                            }
                        }
                    }
                    page += 1;
                }
			} catch (Exception e) {
				e.printStackTrace();
                continue;
			}
		}
	}
    

}
