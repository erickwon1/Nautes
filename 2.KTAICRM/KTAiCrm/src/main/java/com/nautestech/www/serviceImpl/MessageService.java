package com.nautestech.www.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nautestech.www.mapper.ContactMapper;
import com.nautestech.www.model.Contact;

import reactor.core.publisher.Mono;

@Service
public class MessageService {

	private final WebClient webClient;

	public MessageService(WebClient webClient) {
		this.webClient = webClient;
	}

	@Autowired
	private ContactMapper contactMapper;

	// SMS 전송
	public Mono<String> sendSms(Map<String, Object> request) {
		return webClient.post().uri("CPaaS_sendSMS").bodyValue(request).retrieve().bodyToMono(String.class);
	}

	// LMS/MMS 전송
	public Mono<String> sendMms(Map<String, Object> request) {
		return webClient.post().uri("CPaaS_sendMMS").bodyValue(request).retrieve().bodyToMono(String.class);
	}

	public List<Contact> getContactList() {
		return contactMapper.getContactList();
	}
}
