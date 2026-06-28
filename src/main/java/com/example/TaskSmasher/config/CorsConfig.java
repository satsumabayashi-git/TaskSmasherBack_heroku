package com.example.TaskSmasher.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	@Value("${frontend.url}")
	private String url;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// APIエンドポイントのパスパターン
		registry.addMapping("/**")
				// 許可するReactアプリのURL
				.allowedOrigins(url)
				// 許可するHTTPメソッド
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				// 許可するヘッダー
				.allowedHeaders("*")
				// Cookieなどを許可するか
				.allowCredentials(true);
	}
}
