package com.example.websocketdemo.proxy;

public class ComputerFactory implements ProxyFactory{

    @Override
    public void method() {
        System.out.println("买电脑");
    }
}
