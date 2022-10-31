package com.esi.msmatièrespremières;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsMatièresPremièresApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsMatièresPremièresApplication.class, args);
    }

}
