package com.my.demo5.strategy;


public class StrategyTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.setBody(new IntType());
        System.out.println("String-->>>"+context.parseStr("20"));

        context.setBody(new LongType());
        System.out.println("String-->>>"+context.parseStr("20"));

        context.setBody(new DoubleType());
        System.out.println("Stirng-->>>"+context.parseStr("20"));
    }
}
