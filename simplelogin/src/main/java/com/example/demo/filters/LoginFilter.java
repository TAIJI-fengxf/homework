package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.example.demo.po.User;


public class LoginFilter implements Filter{
	private static Logger logger=LoggerFactory.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("LoginFilter-----------init");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		User user=(User) req.getSession().getAttribute("user");
		if(StringUtils.isEmpty(user)&&!req.getRequestURI().contains("login")) {
			
			logger.info("LoginFilter已过滤！");
			res.getWriter().write("Please login first");
			return;
		}
		chain.doFilter(request, response);
		logger.info("LoginFilter------------------执行完毕");
		
	}

	@Override
	public void destroy() {
		logger.info("LoginFilter-------------destroy");
		
	}

}
