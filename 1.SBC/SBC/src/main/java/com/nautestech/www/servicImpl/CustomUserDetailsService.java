package com.nautestech.www.servicImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.MemberMapper;
import com.nautestech.www.model.Constant;
import com.nautestech.www.model.CustomUserDetail;
import com.nautestech.www.model.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private final MemberMapper memberMapper;

	@Override
	public CustomUserDetail loadUserByUsername(String login_id) throws UsernameNotFoundException {
		Member member = memberMapper.findById(login_id);
		if (member == null) {
			throw new UsernameNotFoundException("User not found");
		}
//		User user = User.builder().username(login_id).password(member.getMember_password()).roles("ADMIN").build();
		CustomUserDetail customUserDetail = new CustomUserDetail();
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		grantedAuthorityList.add(new SimpleGrantedAuthority(Constant.ROLE_TYPE.ROLE_MEMBER.toString()));

		customUserDetail.setUsername(login_id);
		customUserDetail.setPassword(member.getMember_password());
		customUserDetail.setAuthorities(grantedAuthorityList);

		return customUserDetail;
	}
}