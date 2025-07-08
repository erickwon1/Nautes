package com.nautestech.www.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class CustomUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Collection<? extends GrantedAuthority> authorities;
	private String username;
	private String password;
}
