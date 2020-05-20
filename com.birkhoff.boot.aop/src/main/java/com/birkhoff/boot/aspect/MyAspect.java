package com.birkhoff.boot.aspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    @Before("execution(* com.birkhoff.boot.service.impl.UserServiceImpl.printUser(..))")
    public void before(){
        System.out.println("before.....");
    }

    @After("execution(* com.birkhoff.boot.service.impl.UserServiceImpl.printUser(..))")
    public void after(){
        System.out.println("after.....");
    }
    @AfterReturning("execution(* com.birkhoff.boot.service.impl.UserServiceImpl.printUser(..))")
    public void afterReturning(){
        System.out.println("afterReturning.....");
    }

    @AfterThrowing("execution(* com.birkhoff.boot.service.impl.UserServiceImpl.printUser(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing.....");
    }
}
