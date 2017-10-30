package com.intellect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class IntellectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntellectDemoApplication.class, args);
	}
}
