package com.my.demo55;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
@MapperScan("com.my.demo55.dao")
public class Demo55Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo55Application.class, args);
    }

}
