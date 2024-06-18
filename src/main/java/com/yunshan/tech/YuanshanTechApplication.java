package com.yunshan.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class YuanshanTechApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuanshanTechApplication.class, args);
    }

}
