package com.birkhoff.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 定义扫描包
@SpringBootApplication
@MapperScan("com.birkhoff.boot.book.mapper")
public class ReadMyBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadMyBookApplication.class, args);
    }
    
}