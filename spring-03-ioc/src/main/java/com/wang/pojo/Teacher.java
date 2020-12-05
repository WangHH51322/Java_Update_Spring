package com.wang.pojo;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/5 22:02
 */
public class Teacher {
    private String name;
    private Integer grade;

    public Teacher(){
        System.out.println("这是一个空参构造,我是一位老师");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
