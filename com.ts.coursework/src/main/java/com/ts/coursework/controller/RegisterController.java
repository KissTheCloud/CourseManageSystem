package com.ts.coursework.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ts.coursework.dto.UserDto;
import com.ts.coursework.service.imp.UserService;
/**
 * @describe 注册用户
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@PostMapping("/registerUser")
	public int registerUser(@RequestBody UserDto userDto) {
		return userService.registerUser(userDto);
	}
	
	@CrossOrigin
	@GetMapping("/getCurrentUser")
	public UserDto getCurrentUser() {
		return userService.getCurrentUser();
	}
}
