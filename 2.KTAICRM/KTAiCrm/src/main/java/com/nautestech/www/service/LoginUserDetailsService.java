package com.nautestech.www.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nautestech.www.model.Member;
import com.nautestech.www.model.Session;
import com.nautestech.www.repository.MemberRepository;
//import com.nautestech.www.entities.T_Company;

//import com.nautestech.www.entities.T_Admin;
//import com.nautestech.www.entities.T_Company;
//import com.nautestech.www.models.Session;
//import com.nautestech.www.repositories.LoginUserDetailsRepository;
//import com.nautestech.www.repositories.T_CompanyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Member> user = memberRepository.findByUsername(username);
		
		Session session = new Session();

		if (user.isPresent()) {
			var userObj = user.get();
		
			session.setUsername(userObj.getUsername());
			session.setPassword(userObj.getPassword());
			session.setEnabled(true);
			session.setAccountNonExpired(true);
			session.setAccountNonLocked(true);
			session.setCredentialsNonExpired(true);
			return session;
		
			
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

}
