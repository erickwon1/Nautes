package com.nautestech.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautestech.www.model.Contact;

@Mapper
public interface ContactMapper {
	public List<Contact> getContactList();
}