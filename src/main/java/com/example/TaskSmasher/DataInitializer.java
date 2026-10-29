package com.example.TaskSmasher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.TaskSmasher.entity.Authentication;
import com.example.TaskSmasher.entity.Role;
import com.example.TaskSmasher.repository.AuthenticationMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
	private final AuthenticationMapper authenticationMapper;

	@Value("${admin.password}")
	private String adminPassword;
	
	@Override
	public void run(String... args) {

		try {
			System.out.println("Spring Bootアプリケーションが起動しました");
	        System.out.println("初期化処理を実行しています");
//	        System.out.println(adminPassword);
//	        System.out.println(adminPassword.equals(""));

			if(!adminPassword.equals("")) {
				Authentication authentication = new Authentication("admin", adminPassword, Role.ADMIN, "displayname");
				authenticationMapper.insert(authentication);
				System.out.println("初期ユーザー:" + adminPassword + "を追加しました");
			}
		} catch (Exception e) {
			System.out.println("初期化処理でエラーが発生しました");
			e.printStackTrace();
		}

	}
}
