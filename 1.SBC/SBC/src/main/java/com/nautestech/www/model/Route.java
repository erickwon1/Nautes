package com.nautestech.www.model;

import lombok.Data;

@Data
public class Route {
	private Integer r_cnt;
	private Integer r_type;
	private String r_src;
	private String r_method;
	private String r_rprnum;
	private String r_proxy_domain;
	private String r_proxy_addr;
	private Integer r_udpport;
	private int r_tcpport;
	private int r_tlsport;
	private String memo;
}