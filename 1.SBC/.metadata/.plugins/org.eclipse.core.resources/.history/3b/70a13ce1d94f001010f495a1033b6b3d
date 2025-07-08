package com.nautestech.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nautestech.www.model.ModifiedTable;
import com.nautestech.www.servicImpl.ModifiedTableService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ModifiedTableController {

	private final ModifiedTableService modifiedtableService;

	@RequestMapping(value = "/management/modifiedTable", method = { RequestMethod.GET, RequestMethod.POST })
	public String proxyChkListAdd(Model model) {
		ModifiedTable modifiedTable = modifiedtableService.getModifiedTable();

		model.addAttribute("modifiedTable", modifiedTable);

		return "/management/modifiedTable";
	}

	@PostMapping("/management/modifiedTable/modify")
	@ResponseBody
	public void modifyProxyChkList(@RequestBody ModifiedTable modifiedtable) {
		modifiedtableService.modifyModifiedTable(modifiedtable);
	}
}