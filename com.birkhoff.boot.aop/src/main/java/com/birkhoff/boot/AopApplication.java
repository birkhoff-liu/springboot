package com.birkhoff.boot;

import com.birkhoff.boot.aspect.MyAspect;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = {"com.birkhoff.boot.aspect"})
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean(name = "myAspect")
	public MyAspect initMyAspect(){
		return new MyAspect();
	}

}
