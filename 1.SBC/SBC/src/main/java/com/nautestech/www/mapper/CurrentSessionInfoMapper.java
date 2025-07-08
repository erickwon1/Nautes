package com.nautestech.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautestech.www.model.CurrentSessionInfo;

@Mapper
public interface CurrentSessionInfoMapper {
	public List<CurrentSessionInfo> getSessions();
}