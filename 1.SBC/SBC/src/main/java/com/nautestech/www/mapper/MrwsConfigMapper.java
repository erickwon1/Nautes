package com.nautestech.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nautestech.www.model.MrwsConfig;

@Mapper
public interface MrwsConfigMapper {
	public MrwsConfig getMrwsConfig();

	public void setupdate();

	public void modifyMrwsConfig(MrwsConfig mrwsConfig);
}