package com.mango.jtt.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Herman Hong
 * Created by Administrator on 2017/6/16.
 */

//交给Spring管理，如果不是自动扫描加载bean的方式，则在xml里配一个即可,refresh发布ContextRefreshedEvent事件时会调用，在bean初始化后
@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private InitService initService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            initService.setProductAndUser();
        }

    }
}


