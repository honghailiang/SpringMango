/**
 *
 */
package com.mango.jtt.springTask;

import org.springframework.stereotype.Service;

/**
 * @author HHL
 *
 * @date 2016年9月30日
 *
 *       spring 定时任务
 */

@Service
public class TaskJob {

	/**
	 * job1
	 */
	public void job1() {
		// 改用spring aspect
		// LogUtil.printInfoLog(getClass(), "任务进行中ing......");
	}

}
