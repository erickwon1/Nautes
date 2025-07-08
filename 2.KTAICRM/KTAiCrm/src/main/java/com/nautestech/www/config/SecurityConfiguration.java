package com.nautestech.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nautestech.www.service.LoginUserDetailsService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private LoginUserDetailsService loginUserDetailsService;

	@Autowired
	private AuthFailureHandler authFailureHandler;

	@Autowired
	private AuthSuccessHandler authSuccessHandler;

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(jpaDaoAuthenticationProvider());
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new CustomPasswordEncoder();
	}

//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	DaoAuthenticationProvider jpaDaoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(loginUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable).httpBasic(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/pw_reset", "/", "/login").permitAll()
						.requestMatchers(AntPathRequestMatcher.antMatcher("/resource/**")).permitAll()
						.requestMatchers(AntPathRequestMatcher.antMatcher("/common/**")).permitAll()
						.requestMatchers(AntPathRequestMatcher.antMatcher("/**")).permitAll().anyRequest()
						.authenticated())
				.formLogin(form -> form.loginPage("/").loginProcessingUrl("/doLogin").defaultSuccessUrl("/")
						.failureHandler(authFailureHandler).successHandler(authSuccessHandler)
						.usernameParameter("param1").passwordParameter("param2").permitAll())
				.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true)
						.deleteCookies("autoLoginId", "autoLoginEnabled")); // 로그아웃 시 자동 로그인 쿠키 삭제;
		return http.build();
	}
}
