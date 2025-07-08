package com.nautestech.www.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nautestech.www.mapper.RouteMapper;
import com.nautestech.www.model.Route;

@Component
public class RouteValidator implements Validator {
	@Autowired
	private RouteMapper routeMapper;

	@Override
	public boolean supports(Class<?> clazz) {
		return Route.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Route route = (Route) target;
		if (route.getR_type() == 4) {
			if (routeMapper.findBySrc(route.getR_src()) != null) {
				errors.rejectValue("r_src", "Src.route.r_src", "이미 존재하는 src입니다.");
			}
		}
		if (route.getR_type() == -1) {
			errors.rejectValue("r_type", "Type.route.r_type", "필수선택 사항입니다.");
		}
		if (route.getR_method().isEmpty()) {
			errors.rejectValue("r_method", "Method.route.r_method", "필수선택 사항입니다.");
		}
	}
}