package com.example.demo.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import groovy.transform.ToString;
import lombok.Data;

@ConfigurationProperties(prefix="mine")
@Component
@Data
@ToString
public class MineBean {
	private String name;
	private int age;
	private int number;
	private String uuid;

}
