package com.birkhoff.boot.controller;

import com.birkhoff.boot.book.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/page")
    public String asyncPage(){
        System.out.println("请求线程名称：" + "【" + Thread.currentThread().getName() + "】");
        // 调用异步服务
        asyncService.generateReport();
        return "async";
    }
}
