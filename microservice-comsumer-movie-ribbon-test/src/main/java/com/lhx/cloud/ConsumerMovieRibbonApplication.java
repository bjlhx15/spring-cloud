package com.lhx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "microservice-provider-user", configuration = com.lhx.config.TestConfiguration.class)
//@ComponentScan(excludeFilters= {@ComponentScan.Filter(type=FilterType.ANNOTATION,value=ExcludeFromComponentScan.class)})
public class ConsumerMovieRibbonApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieRibbonApplication.class, args);
	}
}
