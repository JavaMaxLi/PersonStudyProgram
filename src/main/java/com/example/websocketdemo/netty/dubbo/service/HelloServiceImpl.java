package com.example.websocketdemo.netty.dubbo.service;

public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String msg) {
        System.out.println("服务器接收到的消息为："+msg);
        if (msg != null) {
            return "服务器接收到请求，参数为："+msg;
        } else {
            return "服务器接收到请求!";
        }

    }
}
