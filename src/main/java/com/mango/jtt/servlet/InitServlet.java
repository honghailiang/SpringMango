package com.mango.jtt.servlet;

import com.mango.jtt.po.MangoUser;
import com.mango.jtt.po.Product;
import com.mango.jtt.service.IProductService;
import com.mango.jtt.service.IUserService;
import com.mango.jtt.util.StringUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 * spring容器启动后，InitServlet（Bean）初始化时会调用，初始化数据（产生一个默认商品、普通用户和管理员用户）
 */
@Component
public class InitServlet implements InitializingBean {

    @Autowired
    private IProductService productService;
    @Autowired
    private IUserService userService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //库中没有商品则添加一个
        List<Product> products = productService.getProductList();
        if (null == products || products.isEmpty()){
            Product product = new Product();
            product.setProductName("Mango");
            product.setQuantity(100);
            product.setUnit("个");
            product.setUnitPrice(100);
            productService.saveProduct(product);
        }

        //库中没有用户则添加普通用户和管理员用户
        List<MangoUser> mangoUsers = userService.getUserList();
        if(null == mangoUsers || mangoUsers.isEmpty()){
            MangoUser mangoUser = new MangoUser();
            mangoUser.setUserName("mango");
            mangoUser.setPassword(StringUtil.md5("123456"));
            mangoUser.setRole("ROLE_USER");
            userService.saveUser(mangoUser);

            MangoUser mangoUser1 = new MangoUser();
            mangoUser1.setUserName("manager");
            mangoUser1.setPassword(StringUtil.md5("123456"));
            mangoUser1.setRole("ROLE_MANAGER");
            userService.saveUser(mangoUser1);
        }
    }

}
