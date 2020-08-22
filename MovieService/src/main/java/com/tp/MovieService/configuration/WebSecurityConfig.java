package com.tp.MovieService.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tp.MovieService.Resources.UserDetailsServiceProvider;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceProvider userDetailsServiceProvider;
	
 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.userDetailsService(userDetailsServiceProvider);
 		
 	}

	
 	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.httpBasic().and()
 		.authorizeRequests()
 		.antMatchers("/admin").hasRole("ADMIN")
 		.antMatchers("/*").hasAnyRole("ADMIN","USER")
 		.anyRequest().authenticated()
 		.and()
 		.formLogin();
 		http.csrf().disable();
 	}


	@Bean
	public PasswordEncoder getPassEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
