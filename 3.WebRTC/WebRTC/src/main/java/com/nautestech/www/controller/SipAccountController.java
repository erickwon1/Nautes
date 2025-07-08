// SipAccountController.java
package com.nautestech.www.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nautestech.www.model.SipAccount;
import com.nautestech.www.service.SipAccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SipAccountController {

	private final SipAccountService sipAccountService;

	@GetMapping("/sip")
	public String sipPage() {
		return "sip";
	}

	@ResponseBody
	@GetMapping("/sip/list")
	public List<SipAccount> getSipList() {
		return sipAccountService.getAllAccounts();
	}
}