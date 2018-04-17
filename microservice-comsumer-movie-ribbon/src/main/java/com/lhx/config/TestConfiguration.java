package com.lhx.config;

import org.springframework.context.annotation.Configuration;

import com.lhx.cloud.ExcludeFromComponentScan;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
//@ExcludeFromComponentScan
public class TestConfiguration {
//	@Autowired
//	IClientConfig config;
	
	public IRule ribbonRule() {
		return new RandomRule();
	}	
}
