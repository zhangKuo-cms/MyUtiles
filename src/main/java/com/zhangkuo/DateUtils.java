package com.zhangkuo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/** 
* @author 作者 zk: 
* @version 创建时间：2019年11月8日 下午1:06:56 
*/
public class DateUtils {
	static final long millionSecondsPerDay = 1000 * 60 * 60 * 24;
	
	/**
	 * 计算年龄
	 * Date():compareTo(Date anotherDate);比较两个日期的顺序
	 * @param birthday
	 * @return
	 */
	public static int countAge(Date birthday) {
		
		if (birthday.compareTo(new Date()) > 0) {
			throw new RuntimeException("给定日期不能大于当前日期" + birthday);
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthday);
		
		int bdYear = cal.get(Calendar.YEAR);//获取给定日期的年份
		int bdMonth = cal.get(Calendar.MONTH);//获取给定日期的月份
		int bdDay = cal.get(Calendar.DAY_OF_MONTH);//获取给定日期的天数
		
		System.out.println("year: " + bdYear +" month: " + bdMonth +" day: " + bdDay);
		
		cal.setTime(new Date());
		int currentYear = cal.get(Calendar.YEAR);//获取当前日期的年份
		int currentMonth = cal.get(Calendar.MONTH);//获取当前日期的月份
		int currentDay = cal.get(Calendar.DAY_OF_MONTH);//获取当前日期的天数
		
		System.out.println("year: " + currentYear +" month: " + currentMonth +" day: " + currentDay);
		
		//算出年数差
		int age = currentYear - bdYear;
		//如果当前月份小于给定日期的月份 则年龄减一
		if (currentMonth < bdMonth) {
			age--;
		//如果当前天数小于给定日期的天数 则年龄减一
		}else if (currentMonth == bdMonth && currentDay < bdDay) {
			age--;
		}
		//返回年龄
		return age;
	}
	
	/**
	 * 计算从当前的日期到给定的未来日期还有多少天
	 * @param futureDate
	 * 未来日期
	 * @return
	 * @throws CmsException
	 * 自定义异常
	 */
	public static int remainDays(Date futureDate) throws CmsException{
		if (futureDate.compareTo(new Date()) < 0) {
			throw new CmsException("给定日期不能小于当前日期" + futureDate);
		}
		
		int days = (int)((futureDate.getTime() - new Date().getTime()) / millionSecondsPerDay);
		
		return days;
	}
	
	/**
	 * 判断给定日期和当前日期是否是同一天
	 * @param date
	 * 给定日期
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String datestr = sdf.format(date);
		
		String todaystr = sdf.format(new Date());
		
		return (datestr.equals(todaystr));
	}
	
	/**
	 * 判断是否在本周
	 * @param date
	 * @return
	 */
	public static boolean isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

		firstDayOfWeek.add(Calendar.DATE, -day + 1 + 1);// 后面的+1是因为从周日开始

		// 本周一的日期

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7 - day + 1);

		// 本周星期天的日期

		System.out.println(format.format(lastDayOfWeek.getTime()));

		return (date.getTime() < lastDayOfWeek.getTime().getTime()
				&& date.getTime() > firstDayOfWeek.getTime().getTime());

	}
	
	/**
	 * 判断月份是否相同
	 * @param date
	 * @return
	 * @throws CmsException
	 */
	public static boolean isThisMonth(Date date) throws CmsException{
		Calendar canlendar = Calendar.getInstance();
		canlendar.setTime(date);
		
		int dateYear = canlendar.get(Calendar.YEAR);
		int dateMonth = canlendar.get(Calendar.MONTH);
		int dateDay = canlendar.get(Calendar.DAY_OF_MONTH);
		
		canlendar.setTime(new Date());
		
		int nowYear = canlendar.get(Calendar.YEAR);
		int nowMonth = canlendar.get(Calendar.MONTH);
		int nowDay = canlendar.get(Calendar.DAY_OF_MONTH);
		
		return (dateMonth == nowMonth);
		/*
		 * if (dateYear == nowYear) {
		 * 
		 * }else { return false; }
		 */
	}
	
	/**
	 * 判断月份是否相同
	 * @param date
	 * @return
	 * @throws CmsException
	 */
	public static boolean isThisMonth2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		
		String dateMonth = sdf.format(date);
		
		String nowMonth = sdf.format(new Date());
		
		return (dateMonth.equals(nowMonth)); 
	}
	
	/**
	 *  给定时间对象，初始化到该月初的1日0时0分0秒0毫秒
	 *  获取月初的时间  BOM（begin of the month） 
	 * @param date
	 * @return
	 * 
	 */
	public static Date getBOM(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
		
	}
	
	/**
	 *  先求出下一个月的月初  然后减一秒。就是本月月末的时间
	 *   
	 * @param date
	 * @return
	 */
	public static Date getEOM(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);

		return calendar.getTime();
		
	}
}
