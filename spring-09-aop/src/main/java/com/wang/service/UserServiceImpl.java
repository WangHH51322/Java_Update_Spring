package com.wang.service;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/29 14:55
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加信息");
    }

    @Override
    public void delete() {
        System.out.println("删除信息");
    }

    @Override
    public void update() {
        System.out.println("更新信息");
    }

    @Override
    public void select() {
        System.out.println("选择信息");
    }
}
