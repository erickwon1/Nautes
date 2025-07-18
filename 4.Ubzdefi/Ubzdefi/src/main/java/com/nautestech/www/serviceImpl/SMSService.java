package com.nautestech.www.serviceImpl;

import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.SMSMapper;
import com.nautestech.www.model.SMS;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SMSService {
	private final SMSMapper smsMapper;

	public void sendSMS(SMS sms) {
		smsMapper.sendSMS(sms);
	}
}