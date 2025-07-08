package com.nautestech.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nautestech.www.model.Contact;
import com.nautestech.www.serviceImpl.MessageService;

@Controller
public class WebController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/")
	public String login() {
		return "page/login";
	}

	@GetMapping("/index")
	public String aicrm_index(Model model) {
	    if (messageService == null) {
	        System.err.println(11111);
	    }
		List<Contact> contacts = messageService.getContactList();
		model.addAttribute("contacts", contacts);
		return "page/index";
	}

	@GetMapping("/pw_reset")
	public String pw_reset() {
		return "page/pw_reset";
	}

}
