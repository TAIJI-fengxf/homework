package com.example.demo.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ChildBeanTwo {
	private String beanTwo;

	public String getBeanTwo() {
		return beanTwo;
	}

	public void setBeanTwo(String beanTwo) {
		this.beanTwo = beanTwo;
	}

	public ChildBeanTwo() {
		super();
	}
	@PostConstruct
	public void start() {
		System.out.println("life start");
	}
	@PreDestroy
	public void stop() {
		System.out.println("life stop");
	}
	

}
