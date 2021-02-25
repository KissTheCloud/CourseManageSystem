package com.ts.coursework.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ts.coursework.dto.UserDto;
import com.ts.coursework.entity.User;
import com.ts.coursework.service.imp.UserService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@GetMapping("/getAllUsers")
	List<UserDto> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@CrossOrigin
	@GetMapping("/delUserById")
	public void delUserById( @RequestParam("id")Long id){
		 userService.delUserById(id);
	}
	
	@CrossOrigin
	@GetMapping("/getUserById")
	public UserDto getUserById( @RequestParam("id")Long id){
		return  userService.getUserById(id);
	}
	
	
	@CrossOrigin
	@PostMapping("/updateUser")
	public void updateUser(@RequestBody User user){
		  userService.updateUser(user);
	}
}
