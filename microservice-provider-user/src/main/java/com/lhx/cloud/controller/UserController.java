package com.lhx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lhx.cloud.entity.User;
import com.lhx.cloud.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/sample/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}
}
