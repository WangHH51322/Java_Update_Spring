package com.wang.demo01;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/8 22:27
 */
//中介代理
public class Proxy implements Rent{

    private LandLord landLord;

    public Proxy(){}

    public Proxy(LandLord landLord){
        this.landLord = landLord;
    }

    @Override
    public void rent() {
        landLord.rent();
    }

    public void seeHouse(){
        System.out.println("中介带你看房!");
    }

    public void fee(){
        System.out.println("中介收中介费");
    }

    public void contact(){
        System.out.println("中介跟你签合同!");
    }
}
