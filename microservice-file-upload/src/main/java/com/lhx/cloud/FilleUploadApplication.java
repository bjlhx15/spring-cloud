package com.lhx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FilleUploadApplication {
	public static void main(String[] args) {
		SpringApplication.run(FilleUploadApplication.class, args);
	}
}
