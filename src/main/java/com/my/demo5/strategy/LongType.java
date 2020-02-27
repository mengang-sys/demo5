package com.my.demo5.strategy;

public class LongType implements ParseStrUtil<Object> {
    @Override
    public Class<? extends Long> parse(String body) {
        return Long.valueOf(Long.parseLong(body)).getClass();
    }
}
