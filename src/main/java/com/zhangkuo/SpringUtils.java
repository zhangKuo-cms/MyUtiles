package com.zhangkuo;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @author 作者 zk: 
* @version 创建时间：2019年11月7日 下午6:54:20 
*/
public class SpringUtils {
	
	/**
	 * 判断字符串是否为空
	 * String类的方法:trim()返回字符串副本，忽略前导空白和尾部空白
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return (str == null || str.trim().equals(""));
	}
	
	/**
	 * 判断字符串是否有值，空引号也算没有值
	 * @param str
	 * @return
	 */
	public static boolean haveValue(String str) {
		return !(str == null || str.trim().equals(""));
	}
	
	/**
	 * 判断移动电话是否正确
	 * Pattern类下的:compile()将给定的正则表达式编译到模式中。
	 * 如果是两个参数是:将给定的正则表达式编译到给定标志的模式中。
	 * Matcher类下的:find()尝试查找与该模式匹配的输入序列的下一个子序列。
	 * 如果有参数是:重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。
	 * @param str
	 * @return
	 */
	public static boolean isMobile(String str) {
		//移动电话的范围
		String regex = "^((13[0-9])|(14[5|7])|(15[0-3]|[5-9])|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
	}
	
	/**
	 * 判断邮箱是否是正确的
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		String regex = "\\w+([-+.\\w+])*@\\w+([-+.\\\\w+])*\\.\\w+([-+.\\\\w+])*$";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
	}
	
	/**
	 * 随机n位英文字符串
	 * random:nextInt(int n)方法:   返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）和指定值（不包括）之间均匀分布的 int值。
	 * random:nextInt()方法:   返回一个伪随机数，它是取自此随机数生成器序列中均匀分布的 int值。
	 * @param n
	 * @return
	 */
	public static String getRandomStr(int n) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			char c = (char)('A' + random.nextInt(26));
			//将char类型的字符串追加到此序列
			sb.append(c);
		}
		//以字符串的形式返回
		return sb.toString();
	}
	
	/**
	 * 获取随机长度为n 的 中文字符串
	 * @return
	 */
	public static String getRandomCn(int n ) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getRandomCn());
		}
		return sb.toString();
	}
	
	/**
	 * 获取随机中文
	 * @return
	 */
	private static char getRandomCn() {
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        return str.charAt(0);
	}
}
