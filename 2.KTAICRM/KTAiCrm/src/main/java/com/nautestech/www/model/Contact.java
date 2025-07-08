package com.nautestech.www.model;

import lombok.Data;

@Data
public class Contact {
	Integer id;
	String name;
	String phone_number;
	String company;
	String last_call;
	Integer msg_count;
	Integer email_count;
	Integer call_count;
	Integer total_interactions;
	String created_at;
	String updated_at;
}
