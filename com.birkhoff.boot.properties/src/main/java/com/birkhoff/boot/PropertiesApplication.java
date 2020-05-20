package com.birkhoff.boot;

import com.birkhoff.boot.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.birkhoff.boot"})
@PropertySource(value = {"classpath:jdbc.properties"} , ignoreResourceNotFound = true)
public class PropertiesApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BannerApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PropertiesApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);//设置banner消失
	}



}
