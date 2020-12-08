package com.wang.demo01;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/8 22:30
 */
public class Client {
    public static void main(String[] args) {

        //房东要租房子
        LandLord landLord = new LandLord();

        //代理
        Proxy proxy = new Proxy(landLord);
        proxy.seeHouse();
        proxy.rent();
        proxy.contact();
        proxy.fee();
    }
}
