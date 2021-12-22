package com.birkhoff.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 定义扫描包
@SpringBootApplication
public class ReadMyBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadMyBookApplication.class, args);
    }
    
}