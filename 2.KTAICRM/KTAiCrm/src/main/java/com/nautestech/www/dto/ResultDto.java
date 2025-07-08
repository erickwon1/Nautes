package com.nautestech.www.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class ResultDto { // VIEW RESULT DTO

	private Map<String, Object> attribute = new HashMap<>();

	private boolean result;
	private Object obj;
	private String failMsg;
	private String certification;

	private ResultDto(boolean result, Object obj) {
		this.result = result;
		this.obj = obj;
	}

	private ResultDto(boolean result) {
		this.result = result;
	}

	public static ResultDto success(Object obj) {
		return new ResultDto(true, obj);
	}

	public static ResultDto success() {
		return new ResultDto(true);
	}

	public static ResultDto fail(String failMsg) {
		ResultDto result = new ResultDto(false);
		result.failMsg = failMsg;
		return result;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Object getObj() {
		return obj;
	}

	public <T> T getObj(Class<T> clazz) {
		return clazz.cast(getObj());
	}
}
