package com.birkhoff.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class DynamicPropertiesConfig {
    @Value("${fileName}")
    private String fileName;

    @PostConstruct
    public void init() throws URISyntaxException {

        System.setProperty("archaius.configurationSource.defaultFileName", "dynamic.properties");
//        File file = Paths.get(filepath).toFile();
        Path path = Paths.get(ClassLoader.getSystemResource(fileName).toURI());
        File file = Paths.get(String.valueOf(path)).toFile();

        if (file.exists() && file.isFile()) {
            System.setProperty("archaius.configurationSource.additionalUrls", "file:" + file);
            System.setProperty("archaius.fixedDelayPollingScheduler.initialDelayMills", "1000");
            System.setProperty("archaius.fixedDelayPollingScheduler.delayMills", "1000");
        }
    }
}
