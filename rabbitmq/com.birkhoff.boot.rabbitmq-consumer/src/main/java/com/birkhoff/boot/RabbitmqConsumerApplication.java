package com.birkhoff.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RabbitmqConsumerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BannerApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(RabbitmqConsumerApplication.class);
		builder.run(args);
	}

}
