package com.example.demo.domain;

public class Permissions {
	private String authority;
	private String url;
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Permissions [authority=" + authority + ", url=" + url + "]";
	}
	

}
