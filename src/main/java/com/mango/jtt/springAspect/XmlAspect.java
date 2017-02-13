/**
 * 
 */
package com.mango.jtt.springAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

import com.mango.jtt.util.LogUtil;

/**
 * 基于xml的aop配置
 * 
 * @author HHL
 * 
 * @date 2016年12月6日
 */
public class XmlAspect implements Ordered {
	public void beforeGet() {
		LogUtil.printInfoLog(getClass(), "beforeGet");
	}

	public void afterGet() {
		LogUtil.printInfoLog(getClass(), "afterGet");
	}

	public Object aroundGet(ProceedingJoinPoint joinPoint) {
		LogUtil.printInfoLog(getClass(), "beforeGet--around");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		LogUtil.printInfoLog(getClass(), "afterGet--around");
		return obj;
	}

	public void afterReturningGet(String productId) {
		LogUtil.printInfoLog(getClass(), "afterReturningGet----productId："
				+ productId);
	}

	/*
	 * 配置该切面的的优先级
	 */
	@Override
	public int getOrder() {
		return 0;
	}
}
