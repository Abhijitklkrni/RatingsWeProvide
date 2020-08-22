package com.tp.MovieService.Resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tp.MovieService.Service.UserDetailsProviderService;
import com.tp.MovieService.model.UserDetailsBean;

public class MyUserDetails implements UserDetails {

	private String userName;
	private String password;
	private String expired;
	private String locked;
	private List<GrantedAuthority> authorities;
	
	
	public MyUserDetails(UserDetailsBean udb) {
		
		if(udb != null) {
			this.userName= udb.getUserName();
			this.password = udb.getPassword();
			this.expired = udb.getExpired();
			this.locked =  udb.getLocked();
			this.authorities= populateAuthoritiesList(udb.getAuthorities());
		}else {
			this.userName= "admin";
			this.password = "admin";
			this.expired = "N";
			this.locked =  "N";
		
		}
	}
	
	private List<GrantedAuthority> populateAuthoritiesList(List<String> authoritiesList){
		if(authoritiesList.isEmpty()) return null;
		List<GrantedAuthority> listToReturn = new ArrayList<GrantedAuthority>();
		for(String auth : authoritiesList) {
			listToReturn.add(new SimpleGrantedAuthority(auth));
		}
		return listToReturn;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		
		return this.password;
	}

	@Override
	public String getUsername() {
	
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.expired.equalsIgnoreCase("N");
		
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.locked.equalsIgnoreCase("N");
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.expired.equalsIgnoreCase("N");
		
	}

	@Override
	public boolean isEnabled() {
		return this.expired.equalsIgnoreCase("N");
		
	}

}
