package com.nautestech.www.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.SipAccountMapper;
import com.nautestech.www.model.SipAccount;
import com.nautestech.www.service.SipAccountService;

@Service
public class SipAccountServiceImpl implements SipAccountService {

	@Autowired
	private SipAccountMapper mapper;

	@Override
	public List<SipAccount> getAllAccounts() {
		return mapper.findAll();
	}
}