package com.wang.service;

import com.wang.dao.UserDao;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/5 11:46
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    //利用set方法实现,进行动态注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser(){
        userDao.getUser();
    }
}
