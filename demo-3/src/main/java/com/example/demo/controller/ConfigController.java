package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ConfigBean;

@RestController
public class ConfigController {
	@Autowired
	ConfigBean configBean;
	@RequestMapping(value="/config")
	public String config() {
		return configBean.toString();
	}
	
	

}
