package com.wang.dao;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/5 12:06
 */
public class UserDaoJdbcImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("获取Jdbc数据!");
    }
}
