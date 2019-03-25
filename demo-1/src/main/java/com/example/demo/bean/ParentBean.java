package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParentBean {
	@Autowired
	private ChildBeanOne beanOne;
	@Autowired
	private ChildBeanTwo beanTwo;
	@Value("aaa")
	private String nam;
	
	public ChildBeanOne getBeanOne() {
		return beanOne;
	}
	public void setBeanOne(ChildBeanOne beanOne) {
		this.beanOne = beanOne;
	}
	public ChildBeanTwo getBeanTwo() {
		return beanTwo;
	}
	public void setBeanTwo(ChildBeanTwo beanTwo) {
		this.beanTwo = beanTwo;
	}
	public ParentBean() {
		super();
	}
	
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	/*@Autowired
	public ParentBean(ChildBeanOne beanOne, ChildBeanTwo beanTwo) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
	}*/
	
	public ParentBean(@Autowired ChildBeanOne beanOne, @Autowired ChildBeanTwo beanTwo, String nam) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
		this.nam = nam;
	}
	
	

}
