package com.xiu.utopia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.xiu.utopia.dao")
public class UtopiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtopiaApplication.class, args);
	}
}
