package com.target.myretailrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MyRetailRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailRestApiApplication.class, args);
	}

}
