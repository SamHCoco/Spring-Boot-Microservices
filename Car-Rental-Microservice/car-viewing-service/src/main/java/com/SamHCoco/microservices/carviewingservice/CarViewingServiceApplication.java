package com.SamHCoco.microservices.carviewingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class CarViewingServiceApplication {

	/**
	 * Defines RestTemplate bean for performing API calls to other microservices.
	 * @return RestTemplate object for performing API calls.
	 */
	@Bean
    @LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CarViewingServiceApplication.class, args);
	}

}
