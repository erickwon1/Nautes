package com.nautestech.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

@Configuration
public class WebClientConfig {

	private static final String API_ID = "CPS8960053827TPQIIL";
	private static final String API_PW = "SVK8960053827JRDHUM";
	private static final String BASE_URL = "https://api.communis.kt.com/cpaas/v2.0/";

	@Bean
	WebClient webClient() {
		String credentials = API_ID + ":" + API_PW;
		String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

		return WebClient.builder().baseUrl(BASE_URL).defaultHeader("Authorization", "Basic " + encodedCredentials)
				.defaultHeader("Content-Type", "application/json").build();
	}
}