package com.example.TaskSmasher.config;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler{
	private final ObjectMapper objectMapper;
	
	@Override
	public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response,
	        final Authentication authentication) throws IOException, ServletException {
		String json = objectMapper.writeValueAsString(Map.of("result", "success"));
		
		response.setContentType("application/json; charset=UTF-8");
        response.getWriter().print(json);
		
	}

}
