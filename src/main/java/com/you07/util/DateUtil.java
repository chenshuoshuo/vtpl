package com.you07.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil
{
  private static DateUtil dateUtils;

  public static synchronized DateUtil getDefaultInstance()
  {
    if (dateUtils == null) {
      dateUtils = new DateUtil();
    }
    return dateUtils;
  }

  public String formatYear() {
    SimpleDateFormat sf = new SimpleDateFormat("yyyy");
    return sf.format(new Date());
  }
  public String formatMonth() {
    SimpleDateFormat sf = new SimpleDateFormat("MM");
    return sf.format(new Date());
  }
  public String formatDate(String pattern) {
    SimpleDateFormat sf = new SimpleDateFormat(pattern);
    return sf.format(new Date());
  }
  public String formatWeekDay() {
    DateFormat df = new SimpleDateFormat("yyyy年MM月dd日，EEE", Locale.CHINA);
    return df.format(new Date());
  }
  
  public String formatString(Long date){
	  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  return sf.format(date);
  }
  
  public Long formatLong(String strdate){
	 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 try {
		  Date date = sf.parse(strdate);
		  return date.getTime();
	} catch (Exception e) {
		System.out.println("时间转换异常");
		return null;
	}
	  
  }
  public static void main(String[] args) {
	  
	  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  System.out.println(sf.format(new Date(1420355100000l)));
	  System.out.println(sf.format(new Date(1420358700000l)));
	  
	  System.out.println(DateUtil.getDefaultInstance().formatString(new Date().getTime()));
  }
}