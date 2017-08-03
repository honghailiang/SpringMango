package com.mango.jtt.init;

import com.mango.jtt.servlet.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/6/15.
 * spring容器启动后，bean初始化时会调用，初始化数据（产生一个默认商品、普通用户和管理员用户）
 */
@Component
public class InitMango{

    @Autowired
    private InitService initService;

    @PostConstruct
    public void init() {
        initService.setProductAndUser();
    }

}
