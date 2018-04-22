package com.lhx.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lhx.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {
	private static final Logger logger = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

	@Override
	public UserFeignClient create(Throwable arg0) {
		HystrixClientFallbackFactory.logger.info("fallback reason was:{}", arg0.getMessage());
		return new UserFeignClientWithFactory() {
			@Override
			public User findById(Long id) {
				User user = new User();
				user.setId(-1L);
				return user;
			}
		};
	}
}
