package com.metacube.Assignment8_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class Assignment81Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment81Application.class, args);
	}

}
