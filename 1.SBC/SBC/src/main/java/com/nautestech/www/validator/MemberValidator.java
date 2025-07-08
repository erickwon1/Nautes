package com.nautestech.www.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nautestech.www.mapper.MemberMapper;
import com.nautestech.www.model.Member;

@Component
public class MemberValidator implements Validator {
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member) target;
		if (!member.getMember_password().equals(member.getMember_password_confirm())) {
			errors.rejectValue("member_password_confirm", "PwConfirm.member.member_password_confirm");
		}
		if (memberMapper.findById(member.getMember_id()) != null) {
			errors.rejectValue("member_id", "Id.member.member_id");
		}
	}
}