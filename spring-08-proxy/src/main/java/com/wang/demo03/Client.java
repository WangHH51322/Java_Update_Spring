package com.wang.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/12 21:53
 */
public class Client {

    public static void main(String[] args) {
        //真实角色
        LandLord landLord = new LandLord();

        //代理角色:现在还没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过程序处理角色,来处理我们要调用的接口对象
        pih.setRent(landLord);
        // 这里的proxy就是动态生成的
        Rent proxy= (Rent) pih.getProxy();
        proxy.rent();
    }


}
