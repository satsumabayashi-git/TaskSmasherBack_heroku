package com.example.TaskSmasher.config;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	private final ObjectMapper objectMapper;
	
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
        final Authentication authentication) throws IOException, ServletException {
    	
    		String json = objectMapper.writeValueAsString(Map.of("result", "success"));
    		
		response.setContentType("application/json; charset=UTF-8");
        response.getWriter().print(json);
    }
}