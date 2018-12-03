package com.xiu.followdouban.commonservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiu.followdouban.commonservice.mapper")
public class CommonserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonserviceApplication.class, args);
	}
}
