package com.example.websocketdemo;

import com.example.websocketdemo.proxy.ComputerFactory;
import com.example.websocketdemo.proxy.DynamicProxyFactory;
import com.example.websocketdemo.proxy.ProxyFactory;
import io.netty.util.NettyRuntime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class UserTest {
    public static void main(String[] args) {
        ProxyFactory computer = new ComputerFactory();

        DynamicProxyFactory dynamicProxyFactory = new DynamicProxyFactory(computer);
        //代理类直接使用Proxy返回代理对象
        // ProxyFactory proxy = (ProxyFactory) dynamicProxyFactory.getProxyInstance();
        //直接使用Proxy返回代理对象
        ProxyFactory proxy = (ProxyFactory) Proxy.newProxyInstance(computer.getClass().getClassLoader(),computer.getClass().getInterfaces(),dynamicProxyFactory);

        proxy.method();

    }
}
