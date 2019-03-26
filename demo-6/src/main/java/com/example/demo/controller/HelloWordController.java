package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	
	//@Value("${hello.name}")
	private String name;

	@RequestMapping("/hello")
	public String name() {
		return "Hello World，"+name;
	}
}
