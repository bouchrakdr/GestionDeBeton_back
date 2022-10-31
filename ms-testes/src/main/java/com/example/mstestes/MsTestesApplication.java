package com.example.mstestes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsTestesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTestesApplication.class, args);
    }

}
