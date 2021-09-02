package com.example.websocketdemo.bean;

import java.io.Serializable;

public class UserBean implements Serializable {

    private String name;
    private int age;
    private String address;

    public UserBean() {
    }

    public UserBean(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public UserBean setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserBean setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserBean setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
