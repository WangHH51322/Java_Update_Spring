package com.wang.config;

import com.wang.pojo.User;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/8 21:19
 */
/*
@Configuration 也会注册倒到容器中
               代表这是一个配置类,相当于之前的beans.xml
 */
@Configuration
/*
指定要扫描的包,这个包下的注解就会生效
 */
@ComponentScan("com.wang")
/*
通过import将多个配置类中的内容合并到一起
 */
@Import(MyConfig.class)
public class  MyConfig {

    /*
    @Bean 等价于 <bean id="newUser" class="com.wang.pojo.User"/>
     */
    @Bean
    public User newUser(){
        return new User();
    }
}
