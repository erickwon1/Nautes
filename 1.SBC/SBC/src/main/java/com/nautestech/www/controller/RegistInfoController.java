package com.nautestech.www.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nautestech.www.model.RegistInfo;
import com.nautestech.www.servicImpl.RegistInfoService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RegistInfoController {
	private final RegistInfoService registInfoService;

	@GetMapping("/management/regist_info")
	public String registInfo(Model model) {
		List<RegistInfo> regists = registInfoService.getRegists();

		model.addAttribute("regists", regists);

		return "/management/regist_info";
	}
}