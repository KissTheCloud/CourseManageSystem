package com.ts.coursework.service;

import com.ts.coursework.dto.UserDto;

public interface UserServiceInterface {
	
	int registerUser(UserDto userdto);
//	UserDto getUser(Long userId);
	
	UserDto getCurrentUser();
}
