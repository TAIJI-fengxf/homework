package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.filters.AccessControlFilter;
import com.example.demo.filters.LoginFilter;
import com.example.demo.filters.LoginoutFilter;

@SpringBootApplication
public class SimpleloginApplication {
	
	@Bean
	public FilterRegistrationBean setLoginoutFilter() {
		FilterRegistrationBean filterBean=new FilterRegistrationBean();
		filterBean.setFilter(new LoginoutFilter());
		filterBean.setName("LoginoutFilter");
		filterBean.addUrlPatterns("/*");
		filterBean.setOrder(1);
		return filterBean;
		
	}
	
	@Bean
	public FilterRegistrationBean setLoginFilter() {
		FilterRegistrationBean filterBean=new FilterRegistrationBean();
		filterBean.setFilter(new LoginFilter());
		filterBean.setName("LoginFilter");
		filterBean.addUrlPatterns("/*");
		filterBean.setOrder(2);
		return filterBean;
		
	}
	@Bean
	public FilterRegistrationBean setAccessFilter() {
		FilterRegistrationBean filterBean=new FilterRegistrationBean();
		filterBean.setFilter(new AccessControlFilter());
		filterBean.setName("AccessControlFilter");
		filterBean.addUrlPatterns("/b");
		filterBean.setOrder(3);
		return filterBean;
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SimpleloginApplication.class, args);
	}

}
