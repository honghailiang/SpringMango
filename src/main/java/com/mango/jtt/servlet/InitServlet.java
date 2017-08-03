package com.mango.jtt.servlet;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/15.
 * spring容器启动后，InitServlet（Bean）初始化时会调用，初始化数据（产生一个默认商品、普通用户和管理员用户）
 */
@Component
public class InitServlet implements InitializingBean {

    @Autowired
    private InitService initService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //库中没有商品则添加一个
        initService.setProductAndUser();
    }

}
