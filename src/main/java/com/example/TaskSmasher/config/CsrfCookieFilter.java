package com.example.TaskSmasher.config;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

public class CsrfCookieFilter  extends OncePerRequestFilter{
	
//	 CookieにCSRFを設定する際の名称
   private static final String CSRF_COOKIE_NAME = "_ctkn";
//   CookieにCSRFを設定する際の有効範囲
   private static final String CSRF_COOKIE_PATH = "/";
   
   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       final CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

       if (csrf != null) {
           final String token = csrf.getToken();
           Cookie cookie = WebUtils.getCookie(request, CSRF_COOKIE_NAME);
           if (cookie == null || token != null && !token.equals(cookie.getValue())) {
               cookie = new Cookie(CSRF_COOKIE_NAME, token);
               cookie.setPath(CSRF_COOKIE_PATH);
               response.addCookie(cookie);
           }
       }

       filterChain.doFilter(request, response);
   }
}
