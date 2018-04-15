package com.lhx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class MicroserviceSampleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSampleProviderUserApplication.class, args);
	}
}
