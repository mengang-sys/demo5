package com.my.demo5.strategy;

public class IntType implements ParseStrUtil<Object> {
    @Override
    public Class<? extends Integer> parse(String body) {
        return Integer.valueOf(Integer.parseInt(body)).getClass();
    }
}
