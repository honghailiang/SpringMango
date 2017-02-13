/**
 * 
 */
package com.mango.jtt.dao;

import java.util.List;

/**
 * dao处理基类接口
 * 
 * @author HHL
 * 
 * @date 2016年11月29日
 */
public interface IMangoDao {

	/**
	 * 根据查询条件获取查询结果
	 * 
	 * @return
	 */
	List list(String querySql);

	/**
	 * 根据id获取对象
	 * 
	 * @param clazz
	 * @param productId
	 * @return
	 */
	Object get(Class clazz, String productId);

	/**
	 * 保存对象
	 * 
	 * @param object
	 */
	void saveBean(Object object);

	/**
	 * 更新对象
	 * 
	 * @param object
	 */
	void updateBean(Object object);
}
