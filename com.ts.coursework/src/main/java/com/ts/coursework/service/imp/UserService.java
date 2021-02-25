package com.ts.coursework.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ts.coursework.dto.UserDto;
import com.ts.coursework.entity.Role;
import com.ts.coursework.entity.User;
import com.ts.coursework.mapper.UserMapper;
import com.ts.coursework.service.UserServiceInterface;

@Service
public class UserService implements UserDetailsService, UserServiceInterface {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.getUserByName(username);// ?通过名字登录还是通过id登录
		if (user == null) {
			throw new UsernameNotFoundException("账户不存在");
		}
		user.setRoles(userMapper.getRolesByUserId(user.getId()));
		return user;
	}

	@Override
	public int registerUser(UserDto userDto) {
		String role = userDto.getRole();
		userDto.setEnabled(true);
		userDto.setLocked(false);
		userDto.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
		if (userMapper.addUser(userDto) > 0) {
			if ("teacher".equals(role)) {
				userMapper.addRoleForUser(userDto.getId(), 1);
			} else if ("student".equals(role)) {
				userMapper.addRoleForUser(userDto.getId(), 2);
			}
		}
		return -1;
	}

	@Override
	public UserDto getCurrentUser() {
		 User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 UserDto userDto =new UserDto(user);
		 userDto.setRole(user.getRoles().get(0).getNameZh());
		return userDto;
	}
	
	public List<UserDto> getAllUsers(){
		List<User> users=userMapper.getAllUser();
		List<UserDto> userDtos=new ArrayList<UserDto>();
		for(User user:users) {
			UserDto userDto=new UserDto(user);
			List<Role> roles =userMapper.getRolesByUserId(user.getId());
			userDto.setRole(roles.get(0).getNameZh());
			userDtos.add(userDto);
		}
		return userDtos;
	}
	
	public void delUserById(Long id) {
		userMapper.delUserById(id);
	}
	
	public UserDto getUserById(Long id) {
		User user=userMapper.getUserById(id);
		UserDto userDto=new UserDto(user);
		Role role=userMapper.getRolesByUserId(id).get(0);
		userDto.setRole(role.getNameZh());
		return userDto;
	}
	
	public void updateUser(User user) {
		//userMapper.delUserById(user.getId());
		userMapper.updateUser(user);
	}
	
	
}
