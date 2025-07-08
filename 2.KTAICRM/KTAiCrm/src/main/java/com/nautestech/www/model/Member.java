package com.nautestech.www.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Table(name = "member")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq", columnDefinition = "bigint(30) default '' COMMENT 'seq \'")
	private Long seq;
	
	@Column(name = "username", columnDefinition = "varchar(200) default '' COMMENT 'username\'")
	private String username;
	
	@Column(name = "password", columnDefinition = "varchar(200) default '' COMMENT ' password\'")
	private String password;
	
	public void updatePassword(String newPassword) {
		this.password = newPassword;		
	}
}



