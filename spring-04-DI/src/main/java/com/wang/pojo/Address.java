package com.wang.pojo;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/6 16:06
 */
public class Address {

    private String Address;

    @Override
    public String toString() {
        return "Address{" +
                "Address='" + Address + '\'' +
                '}';
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
