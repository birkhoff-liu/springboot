package com.birkhoff.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    public static final String SUCCESS = "ok";

    @RequestMapping("/demoTest")
    public String demoTest() {
        return SUCCESS;
    }
}
