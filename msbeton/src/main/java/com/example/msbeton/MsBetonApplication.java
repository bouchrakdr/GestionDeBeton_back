package com.example.msbeton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsBetonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBetonApplication.class, args);
    }

}
