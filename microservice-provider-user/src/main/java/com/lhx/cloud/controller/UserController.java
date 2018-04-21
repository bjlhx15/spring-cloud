package com.lhx.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.lhx.cloud.entity.User;
import com.lhx.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	private DiscoveryClient discoveryClient;

	
	@GetMapping("/sample/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findOne(id);
	}

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("MIRCOSERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	}
	@GetMapping("/eureka-info")
	public ServiceInstance showInfo() {
	    ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
	    return serviceInstance;
	}
	@GetMapping("/eureka-url")
	public Object serviceUrl2() {
	    List<ServiceInstance> list = discoveryClient.getInstances("MIRCOSERVICE-PROVIDER-USER");
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri();
	    }
	    return null;
	}
	
	@PostMapping("/user")
	public User postUser(@RequestBody User user) {
	    return user;
	}
	
	@GetMapping("/get-user")
	public User getUser(User user) {
	    return user;
	}
	

	@GetMapping("/list-all")
	public List<User> listAll(User user) {
		ArrayList<User> arrayList = Lists.newArrayList();
		User user1 = new User(1L,"zhangsan");
		User user2 = new User(2L,"lisi");
		User user3 = new User(3L,"wangwu");
		User user4 = new User(4L,"zhaoliu");
		arrayList.add(user1);
		arrayList.add(user2);
		arrayList.add(user3);
		arrayList.add(user4);
	    return arrayList;
	}
}
