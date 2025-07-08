package com.nautestech.www.service;

import java.util.HashMap;
import java.util.List;

public interface IList<T> {
	public List<?> getList(HashMap<String, Object> param);
}