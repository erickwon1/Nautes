package com.nautestech.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautestech.www.model.RegistInfo;

@Mapper
public interface RegistInfoMapper {
	public List<RegistInfo> getRegists();
}