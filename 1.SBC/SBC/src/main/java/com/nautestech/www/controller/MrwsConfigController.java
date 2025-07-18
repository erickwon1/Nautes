package com.nautestech.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nautestech.www.model.MrwsConfig;
import com.nautestech.www.servicImpl.MrwsConfigService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MrwsConfigController {

	private final MrwsConfigService mrwsConfigService;

	@RequestMapping(value = "/management/mrwsConfig", method = { RequestMethod.GET, RequestMethod.POST })
	public String proxyChkListAdd(Model model) {
		MrwsConfig mrwsConfig = mrwsConfigService.getMrwsConfig();

		model.addAttribute("mrwsConfig", mrwsConfig);

		return "/management/mrwsConfig";
	}

	@PostMapping("/management/mrwsConfig/modify")
	@ResponseBody
	public void modifyProxyChkList(@RequestBody MrwsConfig mrwsConfig) {
		mrwsConfigService.setupdate();
		mrwsConfigService.modifyMrwsConfig(mrwsConfig);
	}
}