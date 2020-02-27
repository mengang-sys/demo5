package com.my.demo5.DynamicProxy;

/**
 * 被代理类
 */
public class RealSubject implements Subject {
    @Override
    public void hello(String name) {
        System.out.println("hello"+name);
    }

    @Override
    public String bye() {
        System.out.println("bye");
        return "bye";
    }
}
