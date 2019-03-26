package com.example.demo;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.MineBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MineControllerTest {
	private MineBean mb;
	private static final Logger LOGGER=LoggerFactory.getLogger(MineControllerTest.class);
	@PostConstruct
	public void logMessage() {
		LOGGER.debug("Sample Debug Message");
		LOGGER.info("Sample Info Message");
		LOGGER.trace("Sample Trace Message");
		LOGGER.error("Sample Error Message");
		LOGGER.warn("Sample Warn Message");
	}
	@PostConstruct
	@Test
	public void getMineBeanMessage() {
		LOGGER.info(mb.getName());
		LOGGER.info(mb.getUuid());
		LOGGER.info(mb.getAge()+"");
		LOGGER.info(mb.getNumber()+"");
		
	}

}
