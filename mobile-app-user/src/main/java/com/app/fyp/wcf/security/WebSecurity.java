package com.app.fyp.wcf.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.fyp.wcf.service.UserService;



@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final UserService userService;
	//private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//constructor
	public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		
		this.userService = userService;
		//this.userDetailsService=userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_URL)
		.permitAll().anyRequest().authenticated()
		.and()
		.addFilter(getAuthenticationFilter())
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception{
	
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	public AuthenticationFilter getAuthenticationFilter() throws Exception{
		final AuthenticationFilter filter=new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	} 
		
}
