package com.meimeiv.bns;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan(basePackages = "com.meimeiv.bns.dao")
@ComponentScan(basePackages = {"com.meimeiv.bns"})
public class BnsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BnsApplication.class, args);
    }

}
