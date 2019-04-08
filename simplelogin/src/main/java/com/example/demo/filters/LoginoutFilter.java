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

import com.example.demo.po.User;

public class LoginoutFilter implements Filter{
	private static Logger logger=LoggerFactory.getLogger(LoginoutFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("LoginoutFilter------------------init");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		User user=(User) req.getSession().getAttribute("user");
		if (req.getRequestURI().contains("loginout")) {
            // 如果调用的是退出接口
            if (req.getSession() == null || user == null) {
                //用户session不存在，处于已经登出状态，直接返回
            	logger.info("LoginoutFilter已过滤！");
                res.getWriter().write("User has loginouted .");
                return;
            }
            // 如果是登出端口，则直接删除session进行登出操作，不用进入到controller 层
            req.getSession().removeAttribute("user");
            res.getWriter().write("Loginout success!");
            return;
        }
		chain.doFilter(request, response);
        logger.info("LoginoutFilter------------------执行完毕");
		
	}

	@Override
	public void destroy() {
		logger.info("LoginoutFilter------------------destroy");
		
	}

}
