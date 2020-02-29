package com.wnxy.springboot.myspringboot03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@MapperScan("com.wnxy.springboot.myspringboot03.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class Myspringboot00Application {

	public static void main(String[] args) {
		SpringApplication.run(Myspringboot00Application.class, args);
	}

}
