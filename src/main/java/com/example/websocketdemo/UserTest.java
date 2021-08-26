package com.example.websocketdemo;

import com.example.websocketdemo.proxy.ComputerFactory;
import com.example.websocketdemo.proxy.DynamicProxyFactory;
import com.example.websocketdemo.proxy.ProxyFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.NettyRuntime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class UserTest {
    public static void main(String[] args) {
        byteBufTest();

    }


    public static void byteBufTest() {

        ByteBuf buf = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            buf.writeByte(i);
        }

        System.out.println("buf的大小为："+buf.capacity());

        for (int i = 0; i < 10; i++) {
            System.out.println(buf.readByte());
        }
    }

    public static void proxy() {
        ProxyFactory computer = new ComputerFactory();

        DynamicProxyFactory dynamicProxyFactory = new DynamicProxyFactory(computer);
        //代理类直接使用Proxy返回代理对象
        // ProxyFactory proxy = (ProxyFactory) dynamicProxyFactory.getProxyInstance();
        //直接使用Proxy返回代理对象
        ProxyFactory proxy = (ProxyFactory) Proxy.newProxyInstance(computer.getClass().getClassLoader(),computer.getClass().getInterfaces(),dynamicProxyFactory);

        proxy.method();
    }
}
