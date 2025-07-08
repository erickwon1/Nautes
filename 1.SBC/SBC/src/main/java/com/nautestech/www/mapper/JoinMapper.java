package com.nautestech.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nautestech.www.model.Member;

@Mapper
public interface JoinMapper {
	public void insertMember(Member member);
}