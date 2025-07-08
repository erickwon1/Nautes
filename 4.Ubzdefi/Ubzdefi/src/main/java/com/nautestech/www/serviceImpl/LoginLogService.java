package com.nautestech.www.serviceImpl;

import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.LoginLogMapper;
import com.nautestech.www.model.LoginLog;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginLogService {
	private final LoginLogMapper loginLogMapper;

	public void insertLoginLog(LoginLog loginLog) {
		loginLogMapper.insertLoginLog(loginLog);
	}
}