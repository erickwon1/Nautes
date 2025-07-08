package com.nautestech.www.model;

import lombok.Data;

@Data
public class RegPhone {
	Integer rp_seq;
	String rp_useflag;
	String rp_display_name;
	String rp_username;
	String rp_auth_user_name;
	String rp_password;
	Integer rp_expire_time;
	Integer rp_retry_period;
	String rp_regdate;
	String rp_status;
	String rp_updateTime;
}