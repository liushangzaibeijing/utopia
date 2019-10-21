package com.xiu.utopia;

import com.xiu.utopia.utils.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

@MapperScan("com.xiu.utopia.dao")
public class UtopiaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UtopiaApplication.class, args);
		SpringContextUtil.setApplicationContext(context);
	}
}
