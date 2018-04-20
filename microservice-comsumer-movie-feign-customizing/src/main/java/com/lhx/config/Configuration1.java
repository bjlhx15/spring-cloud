package com.lhx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class Configuration1 {
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
}
