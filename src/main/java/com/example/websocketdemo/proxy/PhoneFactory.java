package com.example.websocketdemo.proxy;

public class PhoneFactory implements ProxyFactory{

    @Override
    public void method() {
        System.out.println("买手机");
    }
}
