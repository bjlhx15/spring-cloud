package com.lhx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lhx.cloud.entity.User;
import com.lhx.cloud.feign.FeignClient2;
import com.lhx.cloud.feign.UserFeignClient;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;
	@Autowired
	private FeignClient2 feignClient2;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}

	@GetMapping("/{serviceName}")
	public String findById(@PathVariable String serviceName) {
		return feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
	}
}
