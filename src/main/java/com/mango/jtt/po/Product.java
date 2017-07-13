package com.mango.jtt.po;

import javax.persistence.*;


/**
 * @author HHL
 *
 * @date 2016年9月12日
 *
 *       商品类
 */
@Entity
@Table(name = "product")
public class Product extends BaseBean {
	/**
	 *
	 */
	private static final long serialVersionUID = 3844317879498218112L;

	/**
	 * 商品id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * 库存
	 */
	private double quantity;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 商品图片地址
	 */
	private String picture;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

}
