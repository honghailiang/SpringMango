/**
 * 
 */
package com.mango.jtt.springAspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.mango.jtt.po.Order;
import com.mango.jtt.util.LogUtil;

/**
 * 基于@AspectJ注解的aop配置
 * 
 * @author HHL
 * 
 * @date 2016年10月25日
 */
@Component
@Aspect
@org.springframework.core.annotation.Order(1)
public class LogAspect {

	@AfterReturning("execution(* com.mango.jtt.springTask.TaskJob.job1(..))")
	public void logTaskJob() {
		LogUtil.printInfoLog(getClass(), "任务进行中ing......");
		LogUtil.testLogError("任务进行中ing......", null);
	}
	
	@AfterReturning(pointcut = "execution(* com.mango.jtt.service.OrderServiceImpl.saveOrder(..)) && args(order)")
	public void saveOrder(Order order) {
		LogUtil.printInfoLog(getClass(), "保存订单，订单号为：" + order.getOrderId());
	}

}
