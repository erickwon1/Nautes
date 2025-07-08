package com.nautestech.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nautestech.www.model.Member;

@Mapper
public interface MemberMapper {
	public Member findById(String login_id);
}