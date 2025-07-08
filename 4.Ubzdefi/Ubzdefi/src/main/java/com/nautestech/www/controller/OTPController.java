package com.nautestech.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nautestech.www.model.CustomUserDetail;
import com.nautestech.www.serviceImpl.AdminService;
import com.nautestech.www.serviceImpl.CustomUserDetailsService;
import com.nautestech.www.serviceImpl.GoogleOTPService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class OTPController {

	private final GoogleOTPService googleOTPService;
	private final AdminService adminService;
	private final CustomUserDetailsService userDetailsService;

	@PostMapping("/otpsetup")
	public String otpSetupPage(HttpServletRequest request, @RequestParam String login_id, Model model) {
		String secret = googleOTPService.createSecretKey();
		String issuer = "UBZ DEFI";

		adminService.saveOtpSecret(login_id, secret);

		HttpSession session = request.getSession();
		session.setAttribute("verify_reason", "login");

		CustomUserDetail user;
		user = (CustomUserDetail) userDetailsService.loadUserByUsername(login_id);
		session.setAttribute("pre_auth_user", user);
		session.setAttribute("verify_reason", "login");

		String qrText = googleOTPService.buildQrText(secret, login_id, issuer);

		model.addAttribute("qrText", qrText);
		model.addAttribute("secret", secret);
		model.addAttribute("login_id", login_id);

		return "otp/setup";
	}

}