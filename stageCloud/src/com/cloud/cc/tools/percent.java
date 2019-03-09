package com.cloud.cc.tools;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 常用工具
 * @author 
 */
public class percent{
	
	/**
	 * 计算百分�?
	 * @param p1
	 * @param p2
	 */
	public static String percents( double  p1,  double  p2){
	   if(p1==0||p2==0){
		   return "0.00%";
	   }
	   String str;
	   double  p3  =  p1  /  p2;
	   NumberFormat nf  =  NumberFormat.getPercentInstance();
	   nf.setMinimumFractionDigits( 2 );
	   str  =  nf.format(p3);
	   return str;
	} 
	
	/**
	 * 今天�?始时�?
	 * @return 今天�?0�?0�?
	 */
	public static String date1(){
		return DateFormatUtils.format(new Date(),"yyyy-MM-dd 00:00:00");
	}
	
	/**
	 * 今天结束时间
	 * @return 今天�?23:59:5
	 */
	public static String date2(){
		return DateFormatUtils.format(new Date(),"yyyy-MM-dd 23:59:59");
	}
	
	/**
	 * 昨天�?始时�?
	 * @return  昨天�?0�?0�?
	 */
	public static String date3(){
		Date date = new Date();
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DAY_OF_MONTH,-1);
		return  DateFormatUtils.format(ca.getTime(),"yyyy-MM-dd 00:00:00");
	}
	
	/**
	 * 昨天结束时间
	 * @return  昨天�?23�?59�?
	 */
	public static String date4(){
		Date date = new Date();
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DAY_OF_MONTH,-1);
		return  DateFormatUtils.format(ca.getTime(),"yyyy-MM-dd 23:59:59");
	}
	
	/**
	 * �?周开始时�?
	 * @return  �?周的0�?0�?
	 */
	public static String date5(){
		Calendar caa = Calendar.getInstance();
		caa.setTime(new Date());
		caa.add(Calendar.DAY_OF_MONTH,-6);
		return DateFormatUtils.format(caa.getTime(),"yyyy-MM-dd 00:00:00");
	}
	
	/**
	 * �?周结束时�?
	 * @return  �?周的23�?59�?
	 */
	public static String date6(){
		Calendar ca1 = Calendar.getInstance();
		ca1.setTime(new Date());
		ca1.add(Calendar.DAY_OF_MONTH,-1);
		return  DateFormatUtils.format(ca1.getTime(),"yyyy-MM-dd 23:59:59");
	}
	
	
}
