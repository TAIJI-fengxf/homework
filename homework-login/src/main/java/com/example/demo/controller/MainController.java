package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.User;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "Login";
	}
	@GetMapping("/register")
	public String register(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "Register";
	}
	

}
