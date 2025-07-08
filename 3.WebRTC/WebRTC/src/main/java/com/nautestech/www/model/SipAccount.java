package com.nautestech.www.model;

import lombok.Data;

@Data
public class SipAccount {
	private String username; // SIP 사용자명
	private String password; // SIP 비밀번호
	private String extension; // 내선 번호
}