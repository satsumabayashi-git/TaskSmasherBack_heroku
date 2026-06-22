package com.example.TaskSmasher.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final CustomAuthenticationFailureHandler failureHandler;
	private final  CustomLoginSuccessHandler successHandler;
	private final CustomLogoutSuccessHandler logoutSuccessHandler; 
	//	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	@Value("${frontend.url}")
	private String url;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	// SecurityFilterChainのBean定義
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//		CsrfTokenRequestAttributeHandler handler = new CsrfTokenRequestAttributeHandler();
//		handler.setCsrfRequestAttributeName("_csrf");

		http
				// ★HTTPリクエストに対するセキュリティ設定
				.authorizeHttpRequests(authz -> authz
						// 「/login」へのアクセスは認証を必要としない
						.requestMatchers("/login", "/logout").permitAll()
//						.requestMatchers("/authentication").permitAll()
						// 【管理者権限設定】url:/todos/**は管理者しかアクセスできない
						.requestMatchers("/todos/**").hasAuthority("ADMIN")
						// その他のリクエストは認証が必要
						.anyRequest().authenticated())

				//SpringSecurityでのCORS設定
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))

				// ★フォームベースのログイン設定
				.formLogin(form -> form
						// カスタムログインページのURLを指定
						.loginPage("/login")
						// ログイン処理のURLを指定
						.loginProcessingUrl("/authentication")
						// ユーザー名のname属性を指定
						.usernameParameter("usernameInput")
						// パスワードのname属性を指定
						.passwordParameter("passwordInput")
//						// ログイン成功時のリダイレクト先を指定
//						.defaultSuccessUrl("/")
						.successHandler(successHandler)
//						// ログイン失敗時のリダイレクト先を指定
//						.failureUrl("/login?error")
						.failureHandler(failureHandler))
				// ★ログアウト設定
				.logout(logout -> logout
						// ログアウトを処理するURLを指定
						.logoutUrl("/logout")
						// ログアウト成功時のリダイレクト先を指定
//						.logoutSuccessUrl("/login?logout")
						.logoutSuccessHandler(logoutSuccessHandler)
						// ログアウト時にセッションを無効にする
						.invalidateHttpSession(true)
						// ログアウト時にCookieを削除する
						.deleteCookies("JSESSIONID"))
				
				// REST API 用に CSRF 無効
				.csrf((csrf) -> csrf
		                .ignoringRequestMatchers("/authentication","/logout")
		            );
				
				//CSRFを有効化
//				.csrf(csrf -> csrf
//						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//						.ignoringRequestMatchers("/api/login", "/logout")
				
				//login、logout用のAPIのみ権限なしでのアクセスを許可
//		         .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
				

		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		
		
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowedOrigins(List.of(url));
		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowedHeaders(List.of("*"));
		config.setAllowCredentials(true);
		config.setMaxAge(3600L);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}
