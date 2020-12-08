package com.wang.demo01;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/8 22:26
 */
//房东
public class LandLord implements Rent{

    @Override
    public void rent() {
        System.out.println("房东要出租房屋!");
    }
}
