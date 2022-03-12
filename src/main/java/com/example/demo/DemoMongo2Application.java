package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMongo2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoMongo2Application.class, args);
		System.out.println("SERVER STARTED");
	}

}
