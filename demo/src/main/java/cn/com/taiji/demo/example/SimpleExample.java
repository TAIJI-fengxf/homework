package cn.com.taiji.demo.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.taiji.demo.bean.ParentBean;

public class SimpleExample {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:/META-INF/application-context.xml");
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
