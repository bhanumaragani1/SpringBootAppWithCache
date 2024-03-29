package com.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootAppWithCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppWithCacheApplication.class, args);
	}

}
