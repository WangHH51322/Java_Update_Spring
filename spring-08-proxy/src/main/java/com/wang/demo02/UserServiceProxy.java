package com.wang.demo02;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/12 17:03
 */
public class UserServiceProxy implements UserService{

    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        message("add");
        userService.add();
    }

    @Override
    public void delete() {
        message("delete");
        userService.delete();
    }

    @Override
    public void update() {
        message("update");
        userService.update();
    }

    @Override
    public void query() {
        message("query");
        userService.query();
    }

    public void message(String msg){
        System.out.println("日志:使用了" + msg + "方法");
    }

}
