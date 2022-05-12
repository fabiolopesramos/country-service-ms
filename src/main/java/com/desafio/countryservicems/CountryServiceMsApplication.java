package com.desafio.countryservicems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CountryServiceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryServiceMsApplication.class, args);
	}

}
