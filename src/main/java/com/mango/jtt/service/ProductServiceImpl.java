/**
 *
 */
package com.mango.jtt.service;

import java.sql.*;
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
 * @date 2016年11月30日
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
		String sql = "from Product ";
		return dao.list(sql, null);
	}

	@Override
	public Product getProductById(Long productId) {

		return (Product) dao.get(Product.class, productId);
	}

	@Override
	public void saveProduct(Product product) {
		dao.saveBean(product);
	}

	public static void JDBCExample(){
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hhl?useServerPrepStmts=true&cachePrepStmts=true&prepStmtCacheSize=25&prepStmtCacheSqlLimit=2048&characterEncoding=utf8&useSSL=false",
					"root", "123456");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product p WHERE p.productName=?");
			preparedStatement.setString(1,"Mango");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				System.out.println(resultSet.getString(1));
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		JDBCExample();
	}

}
