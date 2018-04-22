package com.lhx.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhx.cloud.entity.User;
import com.lhx.config.Configuration1;
import com.lhx.config.Configuration2;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class,fallback = FeignClient2Fallback.class)
public interface FeignClient2 {
	@RequestMapping(value = "/eureka/apps/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
