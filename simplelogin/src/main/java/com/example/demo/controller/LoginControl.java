package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.po.User;

@RestController
public class LoginControl {
	
	@GetMapping("/login")
	public String login(User user,HttpServletRequest request) {
		if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())) {
			request.getSession().setAttribute("user",user);
			return "login success";
		}else if("user".equals(user.getUsername())&&"user".equals(user.getPassword())) {
			request.getSession().setAttribute("user",user);
			return "login success";
		}else {
			return "login false";
		}
		
		
	}


}
