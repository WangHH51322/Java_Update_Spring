package com.wang.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/12 21:46
 */
//使用这个类,自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    /*
    Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                                          new Class<?>[] { Foo.class },
                                          handler);
     */

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),
                this);
    }

    //处理代理实例,并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理的本质,就是使用反射机制实现
        Object result = method.invoke(rent, args);
        return result;
    }
}
