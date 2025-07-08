package com.nautestech.www.model;

import lombok.Data;

@Data
public class MrwsConfig {
	Integer mrws_id;
	Integer mrws_type;
	String mrws_addr;
	Integer bandwidth;
	Integer mrws_rtp_base_port;
	Integer mrws_rtp_port_range;
}