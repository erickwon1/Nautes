package com.nautestech.www.model;

import lombok.Data;

@Data
public class SMS {
	int seq;
	String send_phone;
	String receive_phone;
	String is_send;
	String sms_content;
	String is_reserve;
	String request_datetime;
	String send_datetime;
	String request_user;
	String receive_user;
	String send_memo;
	String create_datetime;
}
