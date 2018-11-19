package com.you07.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	public static Integer getSemester(){
		Calendar cal = Calendar.getInstance();
		 int month = cal.get(Calendar.MONTH) + 1;
		 if(month>=2 && month<=7){
			 return 2;
		 }
		 if((month>=8 && month<=12)|| month<2){
			 return 1;
		 }
		 return -1;
	}
	
	public static Integer getSchoolYear(){
		Calendar calendar = Calendar.getInstance();
		Integer schoolYear = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		if(month < 7){
			schoolYear -= 1;
		}

		return schoolYear;
	}
	
	public static String strFormat(String str){
		String[] split = str.split(",");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			sb.append(Integer.valueOf(split[i]));
			if(i!=split.length-1){
				sb.append(",");				
			}
		}
		return sb.toString();
	}
	
	public static Integer getWeeks() throws Exception{
		String dataStr = "2016-02-29";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = sdf.parse(dataStr);
		System.out.println(parse.getTime());
		Long c = new Date().getTime()-parse.getTime();
		System.out.println(c/604800000);
		return null;
	}
	
	public static String timeStampFormat(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(timestamp);
	}
	
	
	
	public static String millis2Str(String[] time){
		int startTime = Integer.parseInt(time[0]);
		int endTime = Integer.parseInt(time[1]);
		int c = startTime%3600000;
		int d = endTime%3600000;
		String startStr = ((startTime-c)/3600000==0?"00":(startTime-c)/3600000)+":"+((startTime%3600000/60000)<10?"0"+(startTime%3600000/60000):(startTime%3600000/60000));
		String endStr = ((endTime-d)/3600000==0?"00":(endTime-d)/3600000)+":"+((endTime%3600000/60000)<10?"0"+(endTime%3600000/60000):(endTime%3600000/60000));
		
		return startStr+"-"+endStr;
	}
	
	/**
	 * 	获取今天
	 * */
	public static String getTodayStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	

	/**
	 * 	获取明天
	 * */
	public static String getTomorrowStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return  sdf.format(new Date().getTime()+86400000);
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtils.getSchoolYear());
		System.out.println(DateUtils.getSemester());
	}
	

}
