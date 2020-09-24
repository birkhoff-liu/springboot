package com.birkhoff.boot.dubbo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 第一方式：使用@Value注解
 * 第二方式：直接使用@ConfigurationProperties("database")
 * 第三方式：在启动类applicat中使用@PropertySource(value = {"classpath:jdbc.properties"} , ignoreResourceNotFound = true)方式
 *          这种方式，属性文件可以使非application.properties
 */
@Component
@ConfigurationProperties("database")
public class DatabaseProperties {

//    @Value("${database.driverName}")
    private String driverName = null;

//    @Value("${database.url}")
    private String url = null;

    private String username = null;

    private String password = null;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        System.out.println("driverName = " + driverName);
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

//    @Value("${database.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
//    @Value("${database.password}")
    public void setPassword(String password) {
        this.password = password;
    }
}
