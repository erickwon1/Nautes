package com.nautestech.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import utils.InputLog;

@Configuration
public class AppConfig {

	@Bean
	public InputLog inputLog() {
		return new InputLog();
	}
}