package com.mango.jtt.service;

import com.mango.jtt.BaseTest;
import com.mango.jtt.po.Product;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * ProductServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 14, 2017</pre>
 */
public class ProductServiceImplTest extends BaseTest {

    @Autowired
    private IProductService productService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getProductList()
     */
    @Test
    public void testGetProductList() throws Exception {
        List<Product> products = productService.getProductList();
        for (Product product : products){
            assertEquals("Mango", product.getProductName());
        }
    }

    /**
     * Method: getProductById(Long productId)
     */
    @Test
    public void testGetProductById() throws Exception {
        List<Product> products = productService.getProductList();
        for (Product product : products){
            Product product1 = productService.getProductById(product.getProductId());
            assertEquals(product.getProductName(), product1.getProductName());
        }
    }

    /**
     * Method: saveProduct(Product product)
     */
    @Test
    public void testSaveProduct() throws Exception {
    }

    /**
     * Method: JDBCExample()
     */
    @Test
    public void testJDBCExample() throws Exception {
        ProductServiceImpl.JDBCExample();
    }


} 
