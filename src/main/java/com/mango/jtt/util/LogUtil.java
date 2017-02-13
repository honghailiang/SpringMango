package com.mango.jtt.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HHL
 * 
 * @date 2016年9月27日
 * 
 *       日志工具类类，采用slf4j方式
 */
public class LogUtil {
	// test日志
	public static Logger testLog = LoggerFactory.getLogger("test_logger");
	
	public static boolean isPrintStackTrace = true;
	
	// 记录test错误日志信息
	public static void testLogError(String errorMessage, Exception ex) {
		if (testLog != null) {
			testLog.error(errorMessage);
		}

		if (isPrintStackTrace && ex != null && testLog != null) {
			testLog.error(ex.getMessage(), ex);
		}
	}

	public static void printInfoLog(Class<?> cla, String message) {
		LoggerFactory.getLogger(cla).info(message);
	}
}
