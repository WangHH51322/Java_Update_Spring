package com.wang.log;


import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/29 15:04
 */
public class AfterLog implements AfterReturningAdvice {

    //returnValue:方法执行后的返回值
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + target.getClass().getName() + "的" + method.getClass().getName() + "方法,返回值为" + returnValue);
    }
}
