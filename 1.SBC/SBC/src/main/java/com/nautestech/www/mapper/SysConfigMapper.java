package com.nautestech.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nautestech.www.model.SysConfig;

@Mapper
public interface SysConfigMapper {
	public SysConfig getSysConfig();

	public void modifySysConfig(SysConfig sysConfig);
}