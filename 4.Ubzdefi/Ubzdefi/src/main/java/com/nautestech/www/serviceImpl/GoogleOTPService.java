package com.nautestech.www.serviceImpl;

import org.springframework.stereotype.Service;

import com.nautestech.www.mapper.AdminMapper;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GoogleOTPService {

	private final GoogleAuthenticator gAuth;
	private final AdminMapper adminMapper;

	public String createSecretKey() {
		GoogleAuthenticatorKey key = gAuth.createCredentials();
		return key.getKey(); // 사용자의 secret 키
	}

	public boolean verifyCode(String secret, int code) {
		return gAuth.authorize(secret, code);
	}

	public String buildQrText(String secret, String account, String issuer) {
		// QR 코드에 들어갈 otpauth URL 문자열을 생성
		return String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", issuer, account, secret, issuer);
	}

	public String getOTP(String login_id) {
		return adminMapper.findById(login_id).getAuth_secret();
	}
}