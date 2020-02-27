package com.my.demo5.strategy;

public class Context {

    private ParseStrUtil<?> body;

    public Context() {
    }


    public void setBody(ParseStrUtil<?> json) {
        this.body = json;
    }

    public Class<?> parseStr(String str){
        return body.parse(str);
    }
}
