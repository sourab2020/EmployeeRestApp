package com.trng.restapp.RestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.trng.restapp.RestApp.controller.EmployeeController;

@SpringBootApplication
@ComponentScan({"com.trng.restapp.RestApp.controller","com.trng.restapp.RestApp.services"})
public class RestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAppApplication.class, args);
	}
}
