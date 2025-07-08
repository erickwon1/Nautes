package com.nautestech.www.model;

import lombok.Data;

@Data
public class Admin {
	int admin_id;
	String is_use;
	String admin_name;
	String login_id;
	String login_pwd;
	String admin_phone;
	String auth_type;
	String auth_secret;
	String auth_datetime;
	String login_datetime_befor;
	String login_datetime;
	String login_ip;
	String e_mail;
	String creat_user;
	String creat_datetime;
}
