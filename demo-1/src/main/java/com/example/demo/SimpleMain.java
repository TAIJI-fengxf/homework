package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.bean.ParentBean;


public class SimpleMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		//按包扫描
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
		context.getBean("parentBean",ParentBean.class);
		System.out.println(context.getBean(ParentBean.class).getClass().getName());
	}

}
