package com.nautestech.www.model;

import lombok.Data;

@Data
public class ProxyChkList {
	Integer px_cnt;
	String px_domain;
	String px_addr;
	Integer px_port;
	String px_from;
	String px_to;
	Integer opt_chkcount;
	Integer opt_sndterm;
}