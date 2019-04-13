package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Users;
import com.example.demo.service.BankService;

@RestController
public class MainController {
	@Autowired
	private BankService bankService;
	@GetMapping({"/","/home"})
	public String home() {
		String result=bankService.aaaa();
		return "home"+result;
	}
	@GetMapping({"/user"})
	public Users user() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if ("anonymousUser".equals(principal)) {
			
			return null;
		} else {
			Users user = (Users)principal;
			System.out.println(user);
			return user;
		}
		
	}
	@GetMapping({"admin"})
	public String admin() {
		return "admin";
	}
	

}
