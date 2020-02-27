package com.my.demo5.adapter;

/**
 * 适配器类
 */
public class Adapter implements Targetable {


    private Source source;

    public Adapter(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void mehtod2() {
        System.out.println("this is targertable method");
    }
}
