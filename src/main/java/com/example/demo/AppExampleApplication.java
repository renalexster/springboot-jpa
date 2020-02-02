package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AppExampleApplication {

	public static void main(String[] args) {
		log.info(String.format("Starting application env [%s]", System.getenv()));
		SpringApplication.run(AppExampleApplication.class, args);
	}

}
