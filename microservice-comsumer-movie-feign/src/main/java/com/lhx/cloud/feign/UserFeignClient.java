package com.lhx.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhx.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	// @GetMapping("/sample/{id}")
	@RequestMapping(method = RequestMethod.GET, value = "/sample/{id}")
	public User findById(@PathVariable("id") Long id);

	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public User postUser(@RequestBody User user);
	
	//请求不会成功，只要参数是复杂对象，即使指定了GET方法，feign依然会以post方法进行发送
	@RequestMapping(method = RequestMethod.GET, value = "/get-user")
	public User getUser(User user);
}
