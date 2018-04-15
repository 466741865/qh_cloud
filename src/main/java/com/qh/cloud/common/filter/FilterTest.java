package com.qh.cloud.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Description 过滤器Filter的工作原理
 * @Date 2017年5月12日 下午3:04:41
 * @author QingHang
 * @version 1.0.0
 */
public class FilterTest implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 对request、response进行一些预处理 ： 比如登录时权限校验
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("----调用service之前执行一段代码----");

		// 执行目标资源，放行
		chain.doFilter(request, response);

		System.out.println("----调用service之后执行一段代码----");

	}

	@Override
	public void destroy() {
		System.out.println("----Filter销毁----");
	}

}
