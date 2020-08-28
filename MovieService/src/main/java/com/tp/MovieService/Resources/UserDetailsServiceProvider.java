package com.tp.MovieService.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tp.MovieService.Service.UserDetailsProviderService;
import com.tp.MovieService.model.UserDetailsBean;

@Service
public class UserDetailsServiceProvider implements UserDetailsService {
 
	@Autowired 
	UserDetailsProviderService userDetailsProviderService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("1");
		
		UserDetailsBean udb = userDetailsProviderService.getUserDetailsFromDB(username);
		return new MyUserDetails(udb);
	}

}
