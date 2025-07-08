package com.nautestech.www.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nautestech.www.dto.ResultDto;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                    Authentication authentication) throws IOException {

        // 자동 로그인 체크박스 상태 확인
        String autoLogin = request.getParameter("autoLogin");
        
        // 자동 로그인이 체크되었다면 쿠키 설정
       
        if (autoLogin != null && (autoLogin.equals("true"))) {
            // 사용자 ID 쿠키 설정 (30일 유효)
            String userId = authentication.getName();
            Cookie userIdCookie = new Cookie("autoLoginId", userId);
            userIdCookie.setMaxAge(24 * 60 * 60); // 1일
            userIdCookie.setPath("/");
            response.addCookie(userIdCookie);
            
            // 자동 로그인 활성화 상태 쿠키 설정
            Cookie autoLoginCookie = new Cookie("autoLoginEnabled", "true");
            autoLoginCookie.setMaxAge(24 * 60 * 60); // 1일
            autoLoginCookie.setPath("/");
            response.addCookie(autoLoginCookie);
        }

        ObjectMapper om = new ObjectMapper();
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(om.writeValueAsString(ResultDto.success()));
        response.getWriter().flush();
    }
}
