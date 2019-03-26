package com.example.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@SpringBootApplication
//@ComponentScan("com.example.controller")
public class Application {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(Application.class);
	@PostConstruct
	public void logMessage() {
		LOGGER.debug("Sample Debug Message");
		LOGGER.info("Sample Info Message");
		LOGGER.trace("Sample Trace Message");
		LOGGER.error("Sample Error Message");
		LOGGER.warn("Sample Warn Message");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args ->{
			LOGGER.info("----------list beans:"+ac.getBeanDefinitionCount());
			String[]beanNames =ac.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for(String beanName:beanNames) {
				LOGGER.info(beanName);
			}
		};
	}
	@Bean
	public ApplicationRunner appRunner() {
		return args ->{
			//LOGGER.info();
			LOGGER.info("------Application Runner");
			for(String option:args.getOptionNames()) {
				LOGGER.info(option);
				LOGGER.info("->");
				LOGGER.info(args.getOptionValues(option).stream().collect(Collectors.joining(",","[","]")));
			}
		};
	}
	@Bean
	public ApplicationListener<ApplicationEvent> helloListener() {
		final String HELLO_URL="/hello";
		return (ApplicationEvent event)->{
			ServletRequestHandledEvent e=(ServletRequestHandledEvent)event;
			if(e.getRequestUrl().equals(HELLO_URL)) {
				LOGGER.info("visit hello");
			}
		};
	}*/
	
	
	
}
