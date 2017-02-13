/**
 * 
 */
package com.mango.jtt.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HHL
 * 
 * @date 2016年9月21日 日期工具类
 */
public class DateUtil {
	private static String dateMode1 = "yyyyMMddHHmmss";
	private static String dateMode2 = "yyyy-MM-dd HH:mm:ss";

	private static DateFormat dateFormat1 = new SimpleDateFormat(dateMode1);
	private static DateFormat dateFormat2 = new SimpleDateFormat(dateMode2);

	/**
	 * @return 日期格式yyyyMMddHHmmss
	 */
	public static String getDateFormat1(Date date) {
		return dateFormat1.format(date)
				.toString();
	}

	/**
	 * @return 日期格式yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateFormat2(Date date) {
		return dateFormat2.format(date)
				.toString();
	}
}
