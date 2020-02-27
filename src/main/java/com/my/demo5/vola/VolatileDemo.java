package com.my.demo5.vola;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();//资源类

        for (int i = 0; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j <= 1000; j++) {
                    myData.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value"+myData.number);
       /* new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t updated number value"+myData.number);
        },"AAA").start();

        while(myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");*/


    }
}
