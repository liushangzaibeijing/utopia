package com.xiu.followdouban.commonwebapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.xiu.followdouban.commonwebapi.mapper")
public class CommonServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonServiceProviderApplication.class, args);
	}
}
