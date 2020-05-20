package com.birkhoff.boot.controller;

import com.birkhoff.boot.properties.DatabaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

    @Autowired
    DatabaseProperties properties;

    @RequestMapping(value = "/properties")
    public String getProperties(){

        return properties.getDriverName();
    }
}
