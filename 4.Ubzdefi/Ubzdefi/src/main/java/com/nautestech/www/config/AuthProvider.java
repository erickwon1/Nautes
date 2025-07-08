package com.nautestech.www.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.nautestech.www.model.CustomUserDetail;
import com.nautestech.www.serviceImpl.CustomUserDetailsService;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();

		CustomUserDetail customer = (CustomUserDetail) customUserDetailsService.loadUserByUsername(username);

		if (customer == null) {
			throw new BadCredentialsException("No user registered with this details!");
		} else {
			if (passwordEncoder.matches(pwd, customer.getPassword())) {
				return new UsernamePasswordAuthenticationToken(username, pwd, customer.getAuthorities());
			} else {
				throw new BadCredentialsException("Invalid password!");
			}
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}