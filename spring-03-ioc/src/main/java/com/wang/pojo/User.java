package com.wang.pojo;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/5 21:18
 */
public class User {

    private String name;
    private Integer age;

    public User(String name,Integer age){
        this.name = name;
        this.age = age;
//        System.out.println("这里是无参构造!!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void show(){
        System.out.println("我的名字叫" + this.name + ",我今年" + this.age + "岁");
    }
}
