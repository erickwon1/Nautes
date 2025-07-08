package com.nautestech.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.warrenstrange.googleauth.GoogleAuthenticator;

@Configuration
public class GoogleConfiguration {
	@Bean
	public GoogleAuthenticator googleAuthenticator() {
		return new GoogleAuthenticator();
	}
}