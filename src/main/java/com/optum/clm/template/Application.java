package com.optum.ct.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring application configuration and entry point for the application.
 * Add integration configurations to this class, e.g. @EnableSwagger2, @EnableScheduling etc.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
