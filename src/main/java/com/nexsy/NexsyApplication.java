package com.nexsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.nexsy")
public class NexsyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexsyApplication.class, args);
	}

}
