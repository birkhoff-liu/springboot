package com.birkhoff.boot;

import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ArchaiusApplication {

    private static final Logger logger = LoggerFactory.getLogger(ArchaiusApplication.class);

    @RequestMapping("/")
    @ResponseBody
    String home() {
        DynamicLongProperty dynamicLongProperty = DynamicPropertyFactory.getInstance().getLongProperty("lock.waitTime",1000);
        logger.info(dynamicLongProperty.getName() + ":" + dynamicLongProperty.getValue());
        logger.info("get:" + dynamicLongProperty.get());
        System.out.println(dynamicLongProperty.getName() + ":" + dynamicLongProperty.getValue());
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ArchaiusApplication.class, args);
    }

}