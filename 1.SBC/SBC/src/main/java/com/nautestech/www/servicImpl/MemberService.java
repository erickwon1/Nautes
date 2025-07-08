package com.nautestech.www.servicImpl;

import com.nautestech.www.mapper.MemberMapper;
import com.nautestech.www.model.Member;

//@Service
//@RequiredArgsConstructor
public class MemberService {
	private MemberMapper memberMapper;

	public boolean login(String member_id, String rawPassword) {
		Member member = memberMapper.findById(member_id);
		return member != null && rawPassword.equals(member.getMember_password());
	}
}