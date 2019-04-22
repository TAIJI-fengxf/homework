package com.example.demo.controller;


import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class LoginController {
	
	@Autowired
	private StringRedisTemplate template;
	
	@GetMapping("/loginUser")
	public String loginUser(String username,String password){

	        if("admin".equals(username)&&"123456".equals(password)){
	        	
	            return "Login Success";
	            
	        }else{

	            template.opsForValue().increment("tim",1);

	            if(Integer.parseInt(template.opsForValue().get("tim"))<3){

	                template.opsForValue().set("isLock","0");
	               
	            }else{
	            	
	                template.opsForValue().set("isLock","1");
	                
	                template.expire("isLock",5,TimeUnit.MINUTES);
	                
	                template.expire("tim", 5, TimeUnit.MINUTES);
	                
	            }
	            
	             if("1".equals(template.opsForValue().get("isLock")))  {
	            	 
	                 return "Login Time Over";
	                 
	             }else{
	            	 
	                 return "Login Faild";
	                 
	             }
	          
	        }

	}

}
