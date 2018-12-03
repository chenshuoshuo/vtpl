package com.you07.cas.ruijie.schedule;


import com.you07.client.*;
import com.you07.eas.model.StudentInfo;
import com.you07.eas.model.TeacherInfo;
import com.you07.eas.service.StudentInfoService;
import com.you07.eas.service.TeacherInfoService;
import com.you07.util.DateUtils;
import com.you07.util.StringUtil;
import com.you07.vtpl.model.LocationLatest;
import com.you07.vtpl.service.LocationLatestService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 更新用户信息定时任务
 * @author ZJ
 *
 */
@Component
public class RuijieUpdateUserInfoSchedule implements java.io.Serializable{

	private static final long serialVersionUID = 4861830629498453885L;
	@Resource
	private LocationLatestService locationLatestService;
	@Resource
	private TeacherInfoService teacherInfoService;
	@Resource
	private StudentInfoService studentInfoService;

	private static Map<String, LocationLatest> USER_MAP = new HashMap<String, LocationLatest>();

	/**
	 * 启动任务
	 */
	public void startJob(){
		System.out.println("start update user-info server");
		updateUserInfo();
	}
	
	public void updateUserInfo(){

		initUserMap();

		Boolean hasNextPage = true;// 定义是否还有下一页
		Integer page = 1;// 当前请求的页码
		Integer pageSize = 200;// 每页请求的数据条数，最大只支持200
        int i = 0;
		SamServicePortType samServicePortType = new SamService().getSamServicePort();
		if(samServicePortType == null){
			System.out.println("SAM服务器为null");
			return;
		}
		while(hasNextPage){
			try {
				QueryUserParams param = new QueryUserParams();
				param.setOffSet((page - 1 ) * pageSize);
				param.setLimit(pageSize);
				QueryUserResult queryUserResult = samServicePortType.queryUser(param);

				if(queryUserResult == null){
					return;
				}
				List<UserInfo> userInfoList = queryUserResult.getData();
                System.out.println("userinfo请求次数:"+i++);
				Thread.sleep(500);
//				System.out.println("page:" + page + ", list-size:" + userInfoList.size());
				if(userInfoList == null || userInfoList.size() == 0){
					hasNextPage = false;
					break;
				} else{
					for(UserInfo userInfo : userInfoList){
						String accountId = userInfo.getAccountId();
						String userid = userInfo.getField3();
						if(StringUtil.isNotEmpty(accountId) && StringUtil.isNotEmpty(userid) && USER_MAP.containsKey(userid.toLowerCase())){
							accountId = accountId.toLowerCase();
							userid = userid.toLowerCase();

							LocationLatest mapLocationLatest = USER_MAP.get(userid);

							locationLatestService.invalidAccountId(accountId, userid);
							LocationLatest locationLatest = locationLatestService.get(userid);
							if(locationLatest != null){
								locationLatest.setUserid(userid);
								locationLatest.setRealname(mapLocationLatest.getRealname());
								locationLatest.setGender(mapLocationLatest.getGender());
								locationLatest.setOrgCode(mapLocationLatest.getOrgCode());
								locationLatest.setOrgName(mapLocationLatest.getOrgName());
								locationLatest.setUsrUpdateTime(new Date());
								locationLatestService.update(locationLatest);
							} else{
								locationLatest = new LocationLatest();
								locationLatest.setAccountId(accountId);
								locationLatest.setUserid(userid);
								locationLatest.setRealname(mapLocationLatest.getRealname());
								locationLatest.setGender(mapLocationLatest.getGender());
								locationLatest.setOrgCode(mapLocationLatest.getOrgCode());
								locationLatest.setOrgName(mapLocationLatest.getOrgName());
								locationLatest.setUsrUpdateTime(new Date());
								locationLatestService.add(locationLatest);
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

	public void initUserMap(){
		if(USER_MAP.keySet().size() == 0){
			List<TeacherInfo> teacherInfoList = teacherInfoService.listAll();
			for(TeacherInfo teacherInfo : teacherInfoList){
				LocationLatest locationLatest = new LocationLatest();

				locationLatest.setUserid(teacherInfo.getTeachercode());
				locationLatest.setRealname(teacherInfo.getName());
				locationLatest.setGender(teacherInfo.getGender());
				locationLatest.setOrgCode(teacherInfo.getDepartmentInfo().getXsbmdm());
				locationLatest.setOrgName(teacherInfo.getDepartmentInfo().getXsbmmc());

				USER_MAP.put(teacherInfo.getTeachercode(), locationLatest);
			}

			//String hql = "from StudentInfo where (TO_NUMBER(classInfo.greade, '9999') + TO_NUMBER(classInfo.major.majorLast, '9999')) > " + DateUtils.getSchoolYear();
			//List<StudentInfo> studentInfoList = studentInfoService.getByHql(hql);
			List<StudentInfo> studentInfoList = studentInfoService.getInSchool(DateUtils.getSchoolYear());
			for(StudentInfo studentInfo : studentInfoList){
				LocationLatest locationLatest = new LocationLatest();

				locationLatest.setUserid(studentInfo.getStudentno());
				locationLatest.setRealname(studentInfo.getName());
				locationLatest.setGender(studentInfo.getGender());
				locationLatest.setOrgCode(studentInfo.getClassInfo().getClasscode());
				locationLatest.setOrgName(studentInfo.getClassInfo().getClassname());

				USER_MAP.put(studentInfo.getStudentno(), locationLatest);
			}
			System.out.println("USER_MAP.size:::"+USER_MAP.size());
		}
	}
    
}
