package com.example.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
//@ComponentScan("com.example.controller")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args ->{
			System.out.println("----------list beans:"+ac.getBeanDefinitionCount());
			String[]beanNames =ac.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for(String beanName:beanNames) {
				System.out.println(beanName);
			}
		};
	}
	@Bean
	public ApplicationRunner appRunner() {
		return args ->{
			System.out.println();
			System.out.println("------Application Runner");
			for(String option:args.getOptionNames()) {
				System.out.println(option);
				System.out.println("->");
				System.out.println(args.getOptionValues(option).stream().collect(Collectors.joining(",","[","]")));
			}
		};
	}
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener() {
		final String HELLO_URL="/hello";
		return (ApplicationEvent event)->{
			ServletRequestHandledEvent e=(ServletRequestHandledEvent)event;
			if(e.getRequestUrl().equals(HELLO_URL)) {
				System.out.println("visit hello");
			}
		};
	}
	
	
	
}
