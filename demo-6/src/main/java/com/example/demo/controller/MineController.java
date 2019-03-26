package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.MineBean;

@RestController
public class MineController {
	@Value("${mine.name}")
	private String name;
	@Value("${mine.age}")
	private int age;
	@Value("${mine.number}")
	private int number;
	@Value("${mine.uuid}")
	private String uuid;
	@RequestMapping("/mine")
	public String info() {
		return "name:"+name+"\nage:"+age+"\nnumber:"+number+"\nuuid:"+uuid;
	}

}
