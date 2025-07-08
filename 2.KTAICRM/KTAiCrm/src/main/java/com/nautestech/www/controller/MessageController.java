package com.nautestech.www.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nautestech.www.serviceImpl.MessageService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/index")
public class MessageController {

	@Autowired
	private final MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@PostMapping("/send")
	public Mono<String> sendMessage(@RequestBody Map<String, Object> request) {
		Map<String, Object> messageInfo = (Map<String, Object>) request.get("messageInfo");
		String channel = (String) messageInfo.get("channel");

		if (channel != null) {
			return messageService.sendMms(request);
		} else {
			return messageService.sendSms(request);
		}
	}
}