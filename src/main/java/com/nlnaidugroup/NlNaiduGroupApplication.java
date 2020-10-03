package com.nlnaidugroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NlNaiduGroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(NlNaiduGroupApplication.class, args);
	}
}

