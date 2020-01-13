package com.SamHCoco.microservices.car.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarCatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarCatalogueServiceApplication.class, args);
	}

}
