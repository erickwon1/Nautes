package com.nautestech.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nautestech.www.model.Member;
import com.nautestech.www.servicImpl.JoinService;
import com.nautestech.www.validator.MemberValidator;

import jakarta.validation.Valid;

@Controller
public class JoinController {
	@Autowired
	private JoinService joinService;
	@Autowired
	private MemberValidator memberValidator;

	@GetMapping("/join")
	public String join(Model model) {
		model.addAttribute("member", new Member());
		return "login/join";
	}

	@PostMapping("/join")
	public String join(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
		memberValidator.validate(member, bindingResult);
		if (bindingResult.hasErrors()) {
			return "login/join";
		}
		joinService.setInsert(member);
		return "redirect:/";
	}
}