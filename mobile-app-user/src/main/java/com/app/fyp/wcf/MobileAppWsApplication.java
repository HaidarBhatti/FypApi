package com.app.fyp.wcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.fyp.wcf.security.AppProperties;

@SpringBootApplication
public class MobileAppWsApplication extends SpringBootServletInitializer{
	
	//here we extended this parent class names as SpringBootServletInitializer()
	//just to stop our mvn installer to create a file of jar extension
	//in the target folder while we will create a file of war ectension that will run 
	//during the runing stage of the file so for this purpose we have to 
	//override the below funtion named as SpringApplicationBuilder()
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MobileAppWsApplication.class);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsApplication.class, args);
	}

	//to encrypt password of the user
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
	
	@Bean(name="AppProperties")
	public AppProperties getAppProperties() {
		return new AppProperties();
	}
	
}
