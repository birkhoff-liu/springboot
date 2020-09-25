package com.birkhoff.boot.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableDubbo
@SpringBootApplication
public class DubboConsumerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BannerApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(DubboConsumerApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);//设置banner消失
	}

}
