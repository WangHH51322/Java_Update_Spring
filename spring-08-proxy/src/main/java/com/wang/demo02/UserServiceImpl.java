package com.wang.demo02;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/12 17:01
 */
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void update() {
        System.out.println("修改用户");
    }

    @Override
    public void query() {
        System.out.println("查询用户!!!");
    }
}
