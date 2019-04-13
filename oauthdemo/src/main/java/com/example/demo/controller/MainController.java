package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@ResponseBody
	@GetMapping("/")
	public String home(Principal principal) {
		return "Hello,"+principal.getName().toString();
	} 
	
	@ResponseBody
	@GetMapping("/a")
	public String a(Principal principal) {
		return "a,"+principal.getName().toString();
	} 
	
}
