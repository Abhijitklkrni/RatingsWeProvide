package com.tp.MovieService.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class AuthoritiesBean {
	
	private String userName;
	private List<? extends GrantedAuthority> authorities;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	

	public void setAuthorities(List<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
