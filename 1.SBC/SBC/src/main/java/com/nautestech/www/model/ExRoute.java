package com.nautestech.www.model;

import lombok.Data;

@Data
public class ExRoute {
	Integer ex_cnt;
	String ex_id;
	String pri_domain;
	String pri_addr;
	String pri_priorty;
	Integer pri_port;
	String sec_domain;
	String sec_addr;
	String sec_priorty;
	Integer sec_port;
}