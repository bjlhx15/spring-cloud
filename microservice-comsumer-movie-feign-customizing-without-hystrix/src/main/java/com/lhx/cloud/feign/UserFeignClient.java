package com.lhx.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.lhx.cloud.entity.User;
import com.lhx.config.Configuration1;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class, fallback = HystrixClientFallback.class)
public interface UserFeignClient {
	@RequestLine("GET /sample/{id}")
	public User findById(@Param("id") Long id);
}
