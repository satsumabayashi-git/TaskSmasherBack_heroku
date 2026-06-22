package com.example.TaskSmasher.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.TaskSmasher.entity.Authentication;

@Mapper
public interface AuthenticationMapper {
	Authentication selectByUsername(String username);

}
