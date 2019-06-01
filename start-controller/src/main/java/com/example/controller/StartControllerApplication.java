package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("com.example")
@SpringBootApplication
@ImportResource(value = {"classpath:dubbo-consumer.xml"})
public class StartControllerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StartControllerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(StartControllerApplication.class, args);
	}
}
