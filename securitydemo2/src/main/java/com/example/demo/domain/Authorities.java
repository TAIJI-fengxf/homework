package com.example.demo.domain;

import org.h2.command.ddl.GrantRevoke;
import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority{
	private String username;
	private String authority;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "Authorities [username=" + username + ", authority=" + authority + "]";
	}
	

}
