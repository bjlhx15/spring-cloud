package com.lhx.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhx.cloud.entity.User;

@FeignClient(name = "microservice-provider-user", /* fallback = HystrixClientFallback.class, */ fallbackFactory = HystrixClientFallbackFactory.class)
public interface UserFeignClient {
	// @GetMapping("/sample/{id}")
	@RequestMapping(method = RequestMethod.GET, value = "/sample/{id}")
	public User findById(@PathVariable("id") Long id);
}