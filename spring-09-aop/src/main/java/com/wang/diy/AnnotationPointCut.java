package com.wang.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/29 16:02
 *
 * 使用注解方式实现AOP
 */

@Aspect  //@Aspect标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.wang.service.UserServiceImpl.*(..))")  //@Before表示下面这个方法在切入点之前执行
                                                                    //"execution(* com.wang.service.UserServiceImpl.*(..))" 就是切入点
    public void before(){
        System.out.println("使用注解方式实现AOP=======前==============");
    }

    @After("execution(* com.wang.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("使用注解方式实现AOP=======后==============");
    }

    //在环绕增强中,我们可以给定一个参数,代表我们要获取处理切入的点
    @Around("execution(* com.wang.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("使用注解方式实现AOP=======环绕前==============");

        Signature signature = joinPoint.getSignature();  //获取签名
        System.out.println("signature" + signature);

        Object proceed = joinPoint.proceed();   //执行方法

        System.out.println("使用注解方式实现AOP=======环绕后==============");

    }
}
