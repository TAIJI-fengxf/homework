package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.bean.AbcBean;

public class JavaConfigTest {
	private AnnotationConfigApplicationContext context;
	@Before
	public void InitialContext() {
		context=new AnnotationConfigApplicationContext(SimpleConfig.class);
		
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
	public void testExampleBean() {
		System.out.println(context.getBean(AbcBean.class).getClass().getName());
	}

}
