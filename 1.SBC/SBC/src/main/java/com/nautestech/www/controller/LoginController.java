package com.nautestech.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginPage(@RequestParam(required = false) String error) {
		if (error != null) {
			// 로그인 실패 시 에러 메시지를 띄울 수 있도록 처리
			System.err.println("로그인 실패");
		}
		return "login/login";
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logoutPage(HttpSession session) {
		session.invalidate();
		return "login/login";
	}

}
