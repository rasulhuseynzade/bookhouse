package com.example.bookhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableFeignClients

public class BookhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookhouseApplication.class, args);
    }

}
