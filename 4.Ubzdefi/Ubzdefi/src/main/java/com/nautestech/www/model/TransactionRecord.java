package com.nautestech.www.model;

import lombok.Data;

@Data
public class TransactionRecord {
	int id;
	String amount;
	String created_at;
	String from_address;
	String to_address;
	String token_address;
	String tx_hash;
	String money;
	String period;
	String coin_name;
	String token_ticker;
	String mainnet;
	String complete;
	int product_id;
	String error;
}
