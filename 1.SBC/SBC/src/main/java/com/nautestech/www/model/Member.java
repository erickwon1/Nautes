package com.nautestech.www.model;

import org.springframework.data.annotation.Transient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Member {
	@NotBlank(message = "{member_id.notblank}")
	private String member_id;
	@NotBlank(message = "{member_name.notblank}")
	private String member_name;
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "{member_password.invalid}")
	private String member_password;
	@Transient
	private String member_password_confirm;
	private String member_etc;
	private String member_gubun;
	private String regdate;
}
