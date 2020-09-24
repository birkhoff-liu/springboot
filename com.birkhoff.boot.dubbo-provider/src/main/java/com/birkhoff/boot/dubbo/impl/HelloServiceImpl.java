package com.birkhoff.boot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.birkhoff.boot.dubbo.HelloService;

@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello , "+name;
    }
}