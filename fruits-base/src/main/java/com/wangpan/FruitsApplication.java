package com.wangpan;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.wangpan.util.UniqueNameGenerator;

@SpringBootApplication
@MapperScan("com.wangpan.mapper")
@ComponentScan(nameGenerator = UniqueNameGenerator.class)
public class FruitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitsApplication.class, args);
	}

}
