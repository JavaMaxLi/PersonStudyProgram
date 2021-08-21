package com.example.websocketdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyFactory implements InvocationHandler {

    public Object factory;

    public DynamicProxyFactory(){}

    public DynamicProxyFactory(Object factory) {
        this.factory = factory;
    }

    //返回要代理的对象
  /*  public Object getProxyInstance() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),this);
    }
*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doInit();
        Object obj = method.invoke(factory,args);
        doEnd();
        return obj;
    }

    public void doInit() {
        System.out.println("去电脑店挑选电脑");
    }

    public void doEnd() {
        System.out.println("买玩电脑回家");
    }
}
