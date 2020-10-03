package com.javatodev.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignIntegrationApplication.class, args);
    }

}
