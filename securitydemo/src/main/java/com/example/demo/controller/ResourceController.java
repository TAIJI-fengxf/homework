package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@GetMapping("/resource/1")
	public String resource() {
		return "resource 1";
	}
	@GetMapping("/resource/2")
	public String resource2() {
		return "resource 2";
	}
	@GetMapping("/admin/1")
	public String admin() {
		return "admin 1";
	}
	@GetMapping("/admin/2")
	public String admin2() {
		return "admin 2";
	}
	@GetMapping("/db/1")
	public String db() {
		return "db 1";
	}
	@GetMapping("/db/2")
	public String db2() {
		return "db 2";
	}
	@GetMapping({"/about"})
    public String about() {
        return "about";
    }
}
