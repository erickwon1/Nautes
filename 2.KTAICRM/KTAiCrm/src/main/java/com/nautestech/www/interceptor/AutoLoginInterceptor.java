package com.nautestech.www.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.nautestech.www.service.LoginUserDetailsService;

@Component
public class AutoLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginUserDetailsService loginUserDetailsService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
  
        Cookie autoLoginCookie = WebUtils.getCookie(request, "autoLoginEnabled");
        Cookie userIdCookie = WebUtils.getCookie(request, "autoLoginId");
        if (autoLoginCookie != null && "true".equals(autoLoginCookie.getValue()) && userIdCookie != null) {
            String userId = userIdCookie.getValue();
            
            try {
                // UserDetails 로드
                UserDetails userDetails = loginUserDetailsService.loadUserByUsername(userId);
                
                // 인증 객체 생성 및 SecurityContext에 설정
                UsernamePasswordAuthenticationToken authentication = 
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                
                SecurityContextHolder.getContext().setAuthentication(authentication);
                
                // 로그인 페이지에 접근하려는 경우 인덱스 페이지로 리다이렉트
                if (request.getRequestURI().equals("/") ) {
                    response.sendRedirect("/index");
                    return false;
                }
            } catch (Exception e) {
                // 자동 로그인 실패 시 쿠키 삭제
                Cookie deleteAutoLoginCookie = new Cookie("autoLoginEnabled", null);
                deleteAutoLoginCookie.setMaxAge(0);
                deleteAutoLoginCookie.setPath("/");
                response.addCookie(deleteAutoLoginCookie);
                
                Cookie deleteUserIdCookie = new Cookie("autoLoginId", null);
                deleteUserIdCookie.setMaxAge(0);
                deleteUserIdCookie.setPath("/");
                response.addCookie(deleteUserIdCookie);
            }
        }
        
        return true;
    }

}


