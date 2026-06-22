package com.example.TaskSmasher.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "adminpass";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println("ハッシュ化されたパスワード: " + encodedPassword);
	}

}
