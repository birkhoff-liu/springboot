package com.birkhoff.boot.controller;

import com.birkhoff.boot.archaius.config.dynamic.DynamicConfigurationSource;
import com.netflix.config.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/archaius")
@Slf4j
public class TestDynamicArchaius {
    @GetMapping("/get")
    public String getValue() throws IOException {
        String file = "custom.properties";
        log.debug("Load custom file...");
        //其实在这之前,config.properties也已经被加载,如果此时custom.properties也定义一个name的k-v,会添加到一个ConcurrentMapConfiguration中
        //读取的时候会顺序读取,命中会马上返回,因此会返回了config.properties的name=doge
        ConfigurationManager.loadPropertiesFromResources(file);
        //custom.properties下age=28
        DynamicIntProperty age = DynamicPropertyFactory.getInstance().getIntProperty("age", 10086);
        System.out.println(age.get());
        return String.valueOf(age.get());
    }
}
