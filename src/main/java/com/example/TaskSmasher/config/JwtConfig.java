package com.example.TaskSmasher.config;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class JwtConfig {
//	Jwtのエンコーダ、デコーダを定義
	
	private String jwtSecret = "11111111111111111111111111111111"; // 32文字以上のランダムな文字列

	@Bean
	SecretKey secretKey() {
		return new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
	}

	@Bean
	JwtEncoder jwtEncoder(SecretKey secretKey) {
		JWK jwk = new OctetSequenceKey.Builder(secretKey.getEncoded())
				.algorithm(JWSAlgorithm.HS256)
				.build();
		JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwkSource);
	}

	@Bean
	JwtDecoder jwtDecoder(SecretKey secretKey) {
		return NimbusJwtDecoder.withSecretKey(secretKey).build();
	}

}
