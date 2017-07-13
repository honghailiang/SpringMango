/**
 * 
 */
package com.mango.jtt.service;

import java.util.List;

import com.mango.jtt.po.Product;

/**
 * 商品服务类
 *
 * @author HHL
 *
 * @date 2016年11月30日
 */
public interface IProductService {
	/**
	 * 获取商品列表
	 *
	 * @return
	 */
	List<Product> getProductList();

	/**
	 * 根据商品id获取商品信息
	 *
	 * @param productId
	 * @return
	 */
	Product getProductById(Long productId);

	/**
	 * 添加商品记录
	 * @param product
	 */
    void saveProduct(Product product);
}
