/**
 *
 */
package com.mango.jtt.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mango.jtt.po.MangoUser;
import com.mango.jtt.po.Order;
import com.mango.jtt.service.IOrderService;
import com.mango.jtt.util.DateUtil;

/**
 * 订单控制类
 *
 * @author HHL
 *
 * @date 2016年12月1日
 */
@Controller
public class OrderController {
	@Autowired
	private IOrderService orderService;

	/**
	 * @param order
	 * @param session
	 * @param model
	 * @return 保存订单
	 */
	@RequestMapping("order/submit")
	public String orderSubmit(Order order, HttpSession session, Model model) {

		order.setTotalPrice(order.getUnitPrice() * order.getNumber());
		order.setOrderId(Long.valueOf(DateUtil.getDateFormat1(new Date())));
		order.setCreateTime(DateUtil.getDateFormat2(new Date()));
		MangoUser user = (MangoUser) session.getAttribute("user");
		if (null != user) {
			order.setUserId(user.getUserId());
			order.setUserName(user.getUserName());
		}
		orderService.saveOrder(order);
		// 改用spring aspect
		// LogUtil.testLogError("addOrder 返回值：" + res, null);
		model.addAttribute("orderId", order.getOrderId());
		// 防止重复提交
		return "redirect:/order/{orderId}";
	}

	/**
	 * @param orderId
	 * @param model
	 * @return 订单信息
	 */
	@RequestMapping("order/{orderId}")
	public String orderSave(@PathVariable Long orderId, Model model) {
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "order_submit";
	}

	/**
	 * @param orderId
	 * @param model
	 * @return 订单支付信息
	 */
	@RequestMapping("pay/{orderId}")
	public String orderPayInfo(@PathVariable Long orderId, Model model) {
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "order_pay";
	}

	/**
	 * @param orderId
	 * @param model
	 * @return 订单支付
	 */
	@RequestMapping("order/{orderId}/pay")
	public String orderPay(@PathVariable Long orderId, Model model) {
		Order order = orderService.getOrderById(orderId);
		order.setStatus("1");
		order.setPayTime(DateUtil.getDateFormat2(new Date()));
		orderService.updateOrder(order);
		return "redirect:/pay/{orderId}";
	}
}
