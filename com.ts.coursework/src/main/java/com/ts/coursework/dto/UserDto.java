package com.ts.coursework.dto;

import com.ts.coursework.entity.User;

public class UserDto extends User {

	private static final long serialVersionUID = 1L;
	
	private String role;
	
	public UserDto() {
		
	}
	
	public UserDto(User user) {
		this.setId(user.getId());
		this.setName(user.getUsername());
		this.setRoles(user.getRoles());
		this.setPhone(user.getPhone());
		this.setSex(user.getSex());
		this.setRealName(user.getRealName());
		this.setAge(user.getAge());
	}
	
	public void setRole(String role) {
		this.role=role;
	}
	
	public String getRole() {
		return this.role;
	}
}
