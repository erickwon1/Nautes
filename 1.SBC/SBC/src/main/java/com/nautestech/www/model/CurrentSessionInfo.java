package com.nautestech.www.model;

import lombok.Data;

@Data
public class CurrentSessionInfo {
	private int c_channel_no;
	private String c_call_id;
	private String c_sessionid;
	private String c_mrwsid;
	private String c_from;
	private String c_to;
	private int c_state;
	private int c_protocol;
	private String c_uasip;
	private String c_uacip;
	private String c_uasrtp;
	private String c_uacrtp;
	private int c_rtp_bandwidth;
	private String c_rtp_payload;
	private String c_rtcp_type;
	private String c_stime;
}
