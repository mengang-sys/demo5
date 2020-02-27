package com.my.demo5.strategy;

public class DoubleType implements ParseStrUtil<Object> {
    @Override
    public Class<? extends Double> parse(String body) {
        return Double.valueOf(Double.parseDouble(body)).getClass();
    }
}
