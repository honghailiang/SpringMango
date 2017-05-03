/**
 * 
 */
package com.mango.jtt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IMangoDao;
import com.mango.jtt.po.Product;

/**
 * @author HHL
 *
 * @date 2016Äê11ÔÂ30ÈÕ
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IMangoDao dao;

	/* (non-Javadoc)
	 * @see com.mango.jtt.service.ProductService#getProductList()
	 */
	@Override
	public List<Product> getProductList() {
		String sql = "from Product";
		return dao.list(sql, null);
	}

	@Override
	public Product getProductById(String productId) {

		return (Product) dao.get(Product.class, productId);
	}

}
