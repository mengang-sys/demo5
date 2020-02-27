package com.my.demo5.vola;

import jdk.nashorn.internal.ir.CallNode;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData {

    volatile int number = 0;

    public void addTo60(){
        this.number=60;
    }

    public  synchronized void addPlusPlus(){
        number++;
    }


}
