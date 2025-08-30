package com.sky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties	//启动配置属性绑定
@SpringBootApplication
public class SkyTakeOutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyTakeOutApplication.class, args);
	}

}
