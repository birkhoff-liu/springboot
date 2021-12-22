package com.birkhoff.boot.book.service.impl;

import com.birkhoff.boot.book.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name){
        if(name == null || name.trim().length() == 0){
            throw new RuntimeException("parameter is null !!!");
        }
        System.out.println("hello : " + name);
    }
}
