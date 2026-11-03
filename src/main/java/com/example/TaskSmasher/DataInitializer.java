package com.example.TaskSmasher;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
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
//	private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);
	
	@Value("${admin.password}")
	private String adminPassword;
	
	@Value("${user1.password}")
	private String user1Password;
	
	@Override
	public void run(String... args) {
//		log.info("DataInitializer started");

		try {
			System.out.println("Spring Bootアプリケーションが起動しました");
	        System.out.println("初期化処理を実行しています");

			if(!adminPassword.equals("")) {
				Authentication authentication1 = new Authentication("admin", adminPassword, Role.ADMIN, "displayname1");
				authenticationMapper.insert(authentication1);
				Authentication authentication2 = new Authentication("TestUser", user1Password, Role.ADMIN, "displayname2");
				authenticationMapper.insert(authentication2);
				System.out.println("初期ユーザーを追加しました");
			}
		} catch (Exception e) {
			System.out.println("初期化処理でエラーが発生しました");
			e.printStackTrace();
		}

	}
}
