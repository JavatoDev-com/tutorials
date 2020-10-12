package com.javatodev.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExceptionHandlingSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionHandlingSpringBootApplication.class, args);
    }

}
