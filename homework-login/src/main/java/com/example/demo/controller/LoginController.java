package com.example.demo.controller;

import java.util.List;
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
public class LoginController {
	
	@Autowired
	private UserServiceImp userService;
	
	@PostMapping("/submit")
	public String submit(User user,BindingResult result,Model model,HttpServletRequest request,Locale locale) {
		ResourceBundle myResources = ResourceBundle.getBundle("message", locale);
		int flag=userService.selectUser(user);
		request.getSession().setAttribute("user", flag);
		//如果登录账号为空
		if(StringUtils.isEmpty(user.getUsername())) {
			FieldError error=new FieldError("user", "username", myResources.getString("nullUsername"));
			result.addError(error);
			return "Login";
		}//如果登录密码为空
		else if(StringUtils.isEmpty(user.getPassword())) {
			FieldError error=new FieldError("user", "password", myResources.getString("nullPassword"));
			result.addError(error);
			return "Login";
		}//如果账号或密码错误
		else if(flag==0){
			FieldError error=new FieldError("user", "password", myResources.getString("errorPassword"));
			result.addError(error);
			return "Login";
		}//如果存在错误
		else if(result.hasErrors()) {
			return "Login";
		}else {
			List<User> userList = userService.selectAllUser();
			model.addAttribute("userList",userList);
			return "Menu";
		}
		
	}

}
