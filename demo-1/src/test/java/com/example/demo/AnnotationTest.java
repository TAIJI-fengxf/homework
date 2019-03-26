package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.bean.ParentBean;

public class AnnotationTest {
	private AnnotationConfigApplicationContext context;
	@Before
	public void InitialContext() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.example");
		context.refresh();
		context.registerShutdownHook();
		
		int count=context.getBeanDefinitionCount();
		System.out.println("Beans的个数："+count);
		
		String[] names=context.getBeanDefinitionNames();
		for(String name:names) {
			System.out.println(name+"--->");
			Object bean=context.getBean(name);
			System.out.println(bean.getClass());
		}
	}
	@Test
	public void test() {
		System.out.println(context.getBean(ParentBean.class).getClass().getName());
	}

}
