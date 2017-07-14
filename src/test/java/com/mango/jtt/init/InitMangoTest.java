package com.mango.jtt.init;

import com.mango.jtt.BaseTest;
import com.mango.jtt.po.Product;
import com.mango.jtt.service.IProductService;
import com.mango.jtt.service.IUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * InitMango Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 13, 2017</pre>
 */
public class InitMangoTest extends BaseTest{

    @Autowired
    private IProductService productService;
    @Autowired
    private IUserService userService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: init()
     */
    @Test
    public void testInit() throws Exception {
        assertNotNull(productService);
        assertNotNull(userService);

        List<Product> products = productService.getProductList();
        for (Product product : products){
            assertEquals("Mango", product.getProductName());
        }
    }


} 
