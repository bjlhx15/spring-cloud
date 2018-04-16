package com.lhx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lhx.cloud.entity.User;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		//http://127.0.0.1:7900/sample/
		//VIP visual IP 
		// HAProxy Heartbeat 软件都有提及VIP
		return restTemplate.getForObject("http://microservice-provider-user/sample/" + id, User.class);
	}
}
