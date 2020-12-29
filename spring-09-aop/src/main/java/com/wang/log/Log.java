package com.wang.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/29 15:00
 */
public class Log implements MethodBeforeAdvice {

    //method:要执行的目标对象的方法
    //objects:参数
    //o:目标对象
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "目标对象的" + method.getClass().getName() + "方法被执行了");
    }
}
