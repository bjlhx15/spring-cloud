package com.lhx.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
	// 传统方式需要在配置文件加上配置
	@Value("${profile}")
	private String profile;

	@GetMapping("/profile")
	public String getProfile() {
		return this.profile;
	}
}
