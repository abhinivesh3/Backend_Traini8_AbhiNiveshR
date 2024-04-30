package com.trainingcenter.backendtrainingcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.trainingcenter.backendtrainingcenter"})
public class BackendtrainingcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendtrainingcenterApplication.class, args);
	}

}
