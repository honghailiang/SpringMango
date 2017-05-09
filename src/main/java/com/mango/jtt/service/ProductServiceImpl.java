/**
 * 
 */
package com.mango.jtt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//		try {
//			Connection connection = dao.getConnection();
//			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product p WHERE p.productName=?");
//			preparedStatement.setString(1,"'Mango'");
//			ResultSet resultSet = preparedStatement.executeQuery();
//			String productId;
//			while (resultSet.next()){
//				productId = (String) resultSet.getObject(1);
//				System.out.println(productId);
//			}
//			resultSet.close();
//			preparedStatement.close();
//			connection.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return dao.list(sql, null);
	}

	@Override
	public Product getProductById(String productId) {

		return (Product) dao.get(Product.class, productId);
	}

}
