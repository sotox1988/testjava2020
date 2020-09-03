package com.example.testjava.matias.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan({"com.example.testjava.matias.people.model.entity"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

