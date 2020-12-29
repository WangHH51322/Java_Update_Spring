package com.wang.diy;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/29 15:48
 */
public class DiyPointCut {
    public void before(){
        System.out.println("===========方法执行前=============");
    }

    public void after(){
        System.out.println("===========方法执行后=============");
    }
}
