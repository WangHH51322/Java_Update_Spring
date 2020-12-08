package com.wang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/8 20:40
 */
/*
* @Component 等价于 <bean id="user" class="com.wang.pojo.User"/> , 即"组件"
* 并且实体类的名字(bean id)默认是类名的小写
* */
@Component
/*
@Scope(value = "singleton") 等价于 <bean id="user" class="com.wang.pojo.User" scope="singleton">
 */
@Scope(value = "singleton")
public class User {

    /*
    属性值的注入使用@Value注解,相当于 <property name="name" value="小刘"/>
     */
    @Value("小刘")
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

//    @Value("小刘")
    public void setName(String name) {
        this.name = name;
    }
}
