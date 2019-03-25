package cn.com.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextTest {
	private AbstractApplicationContext context;
	
	public ApplicationContextTest() {
		//容器初始化
		context=new FileSystemXmlApplicationContext("classpath:/META-INF/application-context.xml");
		context.registerShutdownHook();
		
	}
	

}
