package com.nautestech.www.servicImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.JoinMapper;
import com.nautestech.www.model.Member;
import com.nautestech.www.service.insert;

@Service
public class JoinService implements insert {

	@Autowired
	private JoinMapper joinMapper;

	@Override
	public void setInsert(Member member) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String securePw = encoder.encode(member.getMember_password());
		member.setMember_password(securePw);
		joinMapper.insertMember(member);
	}
}