package com.nautestech.www.model;

import lombok.Data;

@Data
public class SysConfig {
	String sbc_id;
	Integer sip_port;
	String use_protocol;
	Integer media_trans_mod;
	Integer always_nat;
	Integer sscs_port;
	String mrms_addr;
	Integer mrms_port;
	Integer mrws_port;
	Integer ping_pong_count;
	Integer re_regist_time;
	Integer expire_time;
}