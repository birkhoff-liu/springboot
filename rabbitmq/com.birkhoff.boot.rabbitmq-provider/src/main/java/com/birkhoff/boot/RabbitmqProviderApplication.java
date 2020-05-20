package com.birkhoff.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RabbitmqProviderApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BannerApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(RabbitmqProviderApplication.class);
		builder.run(args);
	}

}
