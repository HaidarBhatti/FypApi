package com.mobileappcompanyregister.security;

import com.mobileappcompanyregister.SpringApplicationContext;

public class SecurityConstants {

	public static final long EXPIRATION_TIME = 864000000;// expires after 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/company";

	public static String getTokenSecret() {

		AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("AppProperties");
		return appProperties.getTokenSecret();

	}
}
