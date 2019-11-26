package com.zhangkuo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static void main(String[] args) {
		
		Date birth = new Date(100, 0, 6);
		int age = calAge(birth);
		System.out.println("age is " + age);
		
		System.out.println("今天的月初是 " + getMonthStart(new Date()));
		
		
		System.out.println("今天的月末是 " + getMonthEnd(new Date(119, 1, 23)));
		
		
	}
	
	
	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public static  int calAge(Date birthday) {
		 
		Calendar cal = Calendar.getInstance();  
		cal.setTime(birthday);
		//获取出生的年月日
		int birthYear = cal.get(Calendar.YEAR);
		int birthMonth = cal.get(Calendar.MONTH);
		int birthDate = cal.get(Calendar.DAY_OF_MONTH);
		
		// 获取今天的年月日
		cal.setTime(new Date());
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH);
		int currentDate = cal.get(Calendar.DAY_OF_MONTH);
		
		int age = currentYear-birthYear;
		if(currentMonth<birthMonth)
			age--;
		else if (currentMonth==birthMonth){
			if(currentDate<birthDate)
				age--;
		}
		return age;
	}
	
	//计算从之前日期到现在的年龄
    public   static int countAge(Date date){
		SimpleDateFormat sdf = new	SimpleDateFormat("yyyy");
		int thisyear = Integer.valueOf(sdf.format(new Date()));
		int finalyear = Integer.valueOf(sdf.format(date));
		return thisyear-finalyear;
	}
	
	/**
	 * 判断是否为当天
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat smt = new SimpleDateFormat("yyyyMMdd");
		
		String dateStr = smt.format(date);
		String todayStr = smt.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	
	/**
	 * 判断是否为今年
	 * @param date
	 * @return
	 */
	public static boolean isThisYear(Date date) {
		SimpleDateFormat smt = new SimpleDateFormat("yyyy");
		
		String dateStr = smt.format(date);
		String todayStr = smt.format(new Date());
		return dateStr.equals(todayStr);
	}
	
	
	/** 
	 *  
	 * 给定时间对象，初始化到该月初的1日0时0分0秒0毫秒
	 * 例如  给定 2017-08-23 13:24:16  返回 2017-08-01 00:00:00 
	 * @return
	 */
	public static Date getMonthStart(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//设置0秒
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM,Calendar.AM);
		cal.set(Calendar.DAY_OF_MONTH,1);
		return cal.getTime();
	}
	
	/**
	 * 求月�?
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//设置0秒
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM,Calendar.AM);
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}

	public static Date getCreated() {
		Date created = new Date();
		return created;
	}
	
	public static Date getPeriod() {
		Date created = getCreated();
		return created;
	}
}
