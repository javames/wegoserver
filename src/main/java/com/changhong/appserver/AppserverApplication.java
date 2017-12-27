package com.changhong.appserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.changhong.appserver.mapper")
public class AppserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppserverApplication.class, args);
	}

}
