package com.pratice.springboot;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication
@EnableCaching
public class SpriingCrud2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpriingCrud2Application.class, args);
		
		
	}

}
