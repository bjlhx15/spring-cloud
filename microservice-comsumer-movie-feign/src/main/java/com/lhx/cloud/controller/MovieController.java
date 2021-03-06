package com.lhx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lhx.cloud.entity.User;
import com.lhx.cloud.feign.UserFeignClient;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
	
	@GetMapping("/testPost")
	public User testPost(User user) {
		return userFeignClient.postUser(user);
	}
	//请求不会成功，
	@GetMapping("/testGet")
	public User testGet(User user) {
		return userFeignClient.getUser(user);
	}
}
