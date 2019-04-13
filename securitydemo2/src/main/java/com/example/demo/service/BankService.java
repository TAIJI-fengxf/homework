package com.example.demo.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class BankService {
	
	@Secured("ROLE_USER")
	public String aaaa() {
		return "我是一个被保护的方法";
	}

}
