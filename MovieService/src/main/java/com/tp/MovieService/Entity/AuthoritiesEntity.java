package com.tp.MovieService.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="PERSONAUTHORITIES")
@GenericGenerator(name = "idgen",strategy = "increment")
public class AuthoritiesEntity {
	
	
	@Id
	@GeneratedValue(generator="idgen") 
	private int id;
	private String userName;
	private String authority;
	
	//private List<? extends GrantedAuthority> authorities;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}	
}
