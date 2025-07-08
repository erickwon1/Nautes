package com.nautestech.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebRtcController {
	@GetMapping("/")
	public String call() {
		return "call";
	}
}