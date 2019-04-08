package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainControl {
	
	@GetMapping("/a")
	public String a() {
		return "aaaaaaaaaaaaa";
	}
	@GetMapping("/b")
	public String b() {
		return "bbbbbbbbbbbb";
	}

}
