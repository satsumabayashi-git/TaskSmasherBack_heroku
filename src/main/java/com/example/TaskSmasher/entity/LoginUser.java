package com.example.TaskSmasher.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User{
	private String displayname;
	
	public LoginUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String displayname) {
		super(username, password, authorities);
		this.displayname = displayname;
	}
	
	public String getDisplayname() {
		 return displayname;
		 }
}
