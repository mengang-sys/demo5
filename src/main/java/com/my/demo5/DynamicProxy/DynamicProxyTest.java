package com.my.demo5.DynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        //被代理的对象
        RealSubject realSubject = new RealSubject();

        /*
         通过InvocationHandlerImpl的构造器生成一个InvocationHandler对象
         需要传入被dialing对象作为参数
         */
        InvocationHandlerImpl handler = new InvocationHandlerImpl(realSubject);
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();

        //需要指定类装载器，一组接口及调用处理器生成的动态代理类实例
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
        System.out.println("动态代理对象的类型："+subject.getClass().getName());
        subject.hello("Tom");
        subject.bye();
    }
}
