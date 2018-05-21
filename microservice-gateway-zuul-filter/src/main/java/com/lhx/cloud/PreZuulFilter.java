package com.lhx.cloud;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreZuulFilter extends ZuulFilter {
	private static final Logger log = LoggerFactory.getLogger(PreZuulFilter.class);

	@Override
	public Object run() {
		// 具体执行
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String host = request.getRemoteHost();
		PreZuulFilter.log.warn("请求主机:" + host);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 是否执行次过滤器
		return true;
	}

	@Override
	public int filterOrder() {
		// 执行顺序 ，数值越大 越后执行
		return 1;
	}

	@Override
	public String filterType() {
		// 执行类型
		return "pre";
	}

}
