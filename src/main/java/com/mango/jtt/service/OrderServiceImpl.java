/**
 * 
 */
package com.mango.jtt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IMangoDao;
import com.mango.jtt.po.Order;

/**
 * @author HHL
 *
 * @date 2016Äê12ÔÂ1ÈÕ
 */
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IMangoDao dao;

	/* (non-Javadoc)
	 * @see com.mango.jtt.service.IOrderService#addOrder(com.mango.jtt.po.Order)
	 */
	@Override
	public void saveOrder(Order order) {
		dao.saveBean(order);

	}

	/* (non-Javadoc)
	 * @see com.mango.jtt.service.IOrderService#getOrderById(java.lang.String)
	 */
	@Override
	public Order getOrderById(Long orderId) {
		return (Order) dao.get(Order.class, orderId);
	}

	/* (non-Javadoc)
	 * @see com.mango.jtt.service.IOrderService#updateOrderPay(com.mango.jtt.po.Order)
	 */
	@Override
	public void updateOrder(Order order) {
		dao.updateBean(order);
	}

}
