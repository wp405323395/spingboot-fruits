package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangpan.s")
public class FruitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitsApplication.class, args);
	}

}
