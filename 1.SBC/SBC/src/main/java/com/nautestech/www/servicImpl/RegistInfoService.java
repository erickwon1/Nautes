package com.nautestech.www.servicImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.RegistInfoMapper;
import com.nautestech.www.model.RegistInfo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistInfoService {
	private final RegistInfoMapper registInfoMapper;

	public List<RegistInfo> getRegists() {
		return registInfoMapper.getRegists();
	}
}