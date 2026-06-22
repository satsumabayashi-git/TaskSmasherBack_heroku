package com.example.TaskSmasher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

//@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class TaskSmasherApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskSmasherApplication.class, args);
	}

}
