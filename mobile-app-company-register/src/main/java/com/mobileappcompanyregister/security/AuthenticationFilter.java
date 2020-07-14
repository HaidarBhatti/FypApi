package com.mobileappcompanyregister.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobileappcompanyregister.SpringApplicationContext;
import com.mobileappcompanyregister.service.CompanyService;
import com.mobileappcompanyregister.shared.dto.CompanyDto;
import com.mobileappcompanyregister.ui.model.request.CompanyLoginRequestModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
	
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
												HttpServletResponse res) throws AuthenticationException{
		try {
			CompanyLoginRequestModel creds=new ObjectMapper()
					.readValue(req.getInputStream(), CompanyLoginRequestModel.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
					(
					creds.getEmail() ,
					creds.getPassword(),
					new ArrayList<>()
					)
					);
					
					
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
											HttpServletResponse res,
											FilterChain chain,
											Authentication auth)throws IOException,
	ServletException{
		String userName=((User) auth.getPrincipal()).getUsername();
		
		//String tokenSecret=new SecurityConstants().getTokenSecret();
		
		String token=Jwts.builder()
				.setSubject(userName)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
				.compact();
		
 		CompanyService companyService =(CompanyService)SpringApplicationContext.getBean("companyServiceImpl");
		CompanyDto companyDto=companyService.getCompany(userName);
		
		
		res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		res.addHeader("CompanyID", companyDto.getCompanyId());
		
		//this function helps us to get authorization and company id in the response of the loadUserByEmail() call
	}
	
}
