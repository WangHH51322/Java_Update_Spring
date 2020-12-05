package com.wang.pojo;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/5 16:55
 */
public class Hello {

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
