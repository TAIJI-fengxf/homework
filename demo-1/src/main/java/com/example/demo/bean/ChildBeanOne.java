package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class ChildBeanOne {
	private String beanOne;

	public String getBeanOne() {
		return beanOne;
	}

	public void setBeanOne(String beanOne) {
		this.beanOne = beanOne;
	}

	public ChildBeanOne() {
		super();
	}
	
	

}
