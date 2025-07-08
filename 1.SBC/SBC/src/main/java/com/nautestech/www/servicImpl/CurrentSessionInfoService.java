package com.nautestech.www.servicImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.CurrentSessionInfoMapper;
import com.nautestech.www.model.CurrentSessionInfo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CurrentSessionInfoService {
	@Autowired
	private CurrentSessionInfoMapper currentSessionInfoMapper;

	public List<CurrentSessionInfo> getSessions() {
		return currentSessionInfoMapper.getSessions();
	}
}