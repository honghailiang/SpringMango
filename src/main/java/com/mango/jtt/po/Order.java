package com.mango.jtt.po;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author HHL
 *
 * @date 2016年9月19日 订单信息
 */
@Entity
@Table(name = "omorder")
public class Order extends BaseBean {

	private static final long serialVersionUID = -8131973629927813366L;
	/**
	 * 订单编号
	 */
	@Id
	private Long orderId;
	/**
	 * 商品id
	 */
	private Long productId;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品单价
	 */
	private double unitPrice;
	/**
	 * 购买数量
	 */
	private int number;

	/**
	 * 订单总额
	 */
	private double totalPrice;

	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 购买用户id
	 */
	private Long userId;

	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 订单状态：0：未支付，1:已支付
	 */
	private String status;
	/**
	 * 支付时间
	 */
	private String payTime;
	/**
	 * 地址信息
	 */
	@Embedded
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
}
