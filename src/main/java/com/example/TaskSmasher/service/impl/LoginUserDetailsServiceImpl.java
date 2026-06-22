package com.example.TaskSmasher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.TaskSmasher.entity.Authentication;
import com.example.TaskSmasher.entity.LoginUser;
import com.example.TaskSmasher.entity.Role;
import com.example.TaskSmasher.repository.AuthenticationMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsServiceImpl implements UserDetailsService {
	private final AuthenticationMapper authenticationMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Authentication authentication = authenticationMapper.selectByUsername(username);
		
		if (authentication != null) {
			return new LoginUser(authentication.getUsername(), authentication.getPassword(),
					getAuthorityList(authentication.getAuthority()), authentication.getDisplayname());
		} else {
			throw new UsernameNotFoundException(username + " => 指定しているユーザー名は存在しません");
		}

	}

	/**
	* 権限情報をリストで取得する
	*/
	private List<GrantedAuthority> getAuthorityList(Role role) {
		// 権限リスト
		List<GrantedAuthority> authorities = new ArrayList<>();
		// 列挙型からロールを取得
		authorities.add(new SimpleGrantedAuthority(role.name()));
		// ADMIN ロールの場合、USERの権限も付与
		if (role == Role.ADMIN) {
			authorities.add(new SimpleGrantedAuthority(Role.USER.toString()));
		}
		return authorities;
	}

}
