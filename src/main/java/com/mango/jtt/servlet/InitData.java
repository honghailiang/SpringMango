package com.mango.jtt.servlet;

import com.mango.jtt.po.MangoUser;
import com.mango.jtt.po.Product;
import com.mango.jtt.service.IProductService;
import com.mango.jtt.service.IUserService;
import com.mango.jtt.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Administrator on 2017/6/16.
 */

//交给Spring管理，如果不是自动扫描加载bean的方式，则在xml里配一个即可
@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IProductService productService;
    @Autowired
    private IUserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
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
}


