package com.example.demo.controller;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.User;
import com.example.demo.service.serviceImp.UserServiceImp;

@Controller
public class RegisterController {
	
	@Autowired
	private UserServiceImp userService;
	
	@PostMapping("/setUser")
	public String setUser(User user,BindingResult result,Locale locale) {
		ResourceBundle myResources = ResourceBundle.getBundle("message", locale);
		int flag=userService.selectUsername(user);
		//如果注册账号为空
		if(StringUtils.isEmpty(user.getUsername())) {
			FieldError error=new FieldError("user", "username", myResources.getString("nullUsername"));
			result.addError(error);
			return "Register";
		}//如果注册密码为空
		else if(StringUtils.isEmpty(user.getPassword())) {
			FieldError error=new FieldError("user", "password", myResources.getString("nullPassword"));
			result.addError(error);
			return "Register";
		}//如果注册用户身份为空
		else if(StringUtils.isEmpty(user.getRolename())) {
			FieldError error=new FieldError("user", "rolename", myResources.getString("nullRolename"));
			result.addError(error);
			return "Register";
		}//如果用户已存在
		else if(flag!=0) {
			FieldError error=new FieldError("user", "rolename", myResources.getString("errorRegister"));
			result.addError(error);
			return "Register";
		}else {
			userService.insertUser(user);
			return "Login";
		}
		
		
	}

}
