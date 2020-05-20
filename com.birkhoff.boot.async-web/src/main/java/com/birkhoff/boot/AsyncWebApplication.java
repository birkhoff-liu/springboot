package com.birkhoff.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.birkhoff.boot.servlet")
public class AsyncWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncWebApplication.class, args);
    }
    
}