package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.cognizant")
public class NestedApplication {

	public static void main(String[] args) {
		SpringApplication.run(NestedApplication.class, args);
	}

}
