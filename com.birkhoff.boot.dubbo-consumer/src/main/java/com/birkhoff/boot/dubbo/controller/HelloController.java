package com.birkhoff.boot.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.birkhoff.boot.dubbo.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(version = "1.0.0")
    HelloService helloService;

    @GetMapping("sayHello")
    public String sayHello(String name){
        String result = helloService.sayHello(name);
        System.out.println(result);
        return result;
    }
}
