package com.birkhoff.boot.service.impl;

import com.birkhoff.boot.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name){
        if(name == null || name.trim().length() == 0){
            throw new RuntimeException("parameter is null !!!");
        }
        System.out.println("hello : " + name);
    }
}
