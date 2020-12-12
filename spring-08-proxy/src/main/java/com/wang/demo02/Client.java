package com.wang.demo02;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/12 21:03
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.delete();
    }
}
