package com.example.TaskSmasher.config;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        String json = objectMapper.writeValueAsString(Map.of("result", "failure"));
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().print(json);
        // エラーメッセージをリクエストに追加
        // request.setAttribute("error", "メールアドレスまたはパスワードが正しくありません。");
        // エラーメッセージをログイン画面に渡すクエリパラメータを追加してリダイレクト
        // response.sendRedirect("/login?error=true");
    }

}
