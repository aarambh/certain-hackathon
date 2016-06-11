package com.certainhackathon;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CertainHackathonApplication {

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		SpringApplication.run(CertainHackathonApplication.class, args);
	}
}
