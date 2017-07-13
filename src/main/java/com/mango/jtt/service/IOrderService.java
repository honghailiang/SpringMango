/**
 *
 */
package com.mango.jtt.service;

import com.mango.jtt.po.Order;

/**
 * 订单服务类
 *
 * @author HHL
 *
 * @date 2016年12月1日
 */
public interface IOrderService {

	/**
	 * 添加订单
	 *
	 * @param order
	 */
	void saveOrder(Order order);

	/**
	 * 根据订单号获取订单
	 *
	 * @param orderId
	 * @return
	 */
	Order getOrderById(Long orderId);

	/**
	 * 更新订单
	 *
	 * @param order
	 */
	void updateOrder(Order order);

}
