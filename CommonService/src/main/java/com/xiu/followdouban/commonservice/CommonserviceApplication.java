package com.xiu.followdouban.commonservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("com.xiu.followdouban.commonservice.mapper")
public class CommonserviceApplication {

	public static void main(String[] args) {

		//SpringApplication.run(CommonserviceApplication.class, args);

		new SpringApplicationBuilder(CommonserviceApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

	}
}
