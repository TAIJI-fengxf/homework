package com.example.demo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggeBackApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LoggeBackApplication.class);
	@PostConstruct
	public void logMessage() {
		LOGGER.debug("Sample Debug Message");
		LOGGER.info("Sample Info Message");
		LOGGER.trace("Sample Trace Message");
		LOGGER.error("Sample Error Message");
		LOGGER.warn("Sample Warn Message");
	}

	public static void main(String[] args) {
		SpringApplication.run(LoggeBackApplication.class, args);
	}

}
