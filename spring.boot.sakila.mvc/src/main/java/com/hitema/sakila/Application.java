package com.hitema.sakila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	public void run(String... arg) throws Exception{
		log.info("Server Start at: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")) );
		log.info("http://localhost:8082/sakila/");

	}
}
