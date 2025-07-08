package com.nautestech.www.servicImpl;

import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.MrwsConfigMapper;
import com.nautestech.www.model.MrwsConfig;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MrwsConfigService {

	private final MrwsConfigMapper mrwsConfigMapper;

	public MrwsConfig getMrwsConfig() {
		return mrwsConfigMapper.getMrwsConfig();
	}

	public void setupdate() {
		mrwsConfigMapper.setupdate();
	}

	public void modifyMrwsConfig(MrwsConfig mrwsConfig) {
		mrwsConfigMapper.modifyMrwsConfig(mrwsConfig);
	}
}