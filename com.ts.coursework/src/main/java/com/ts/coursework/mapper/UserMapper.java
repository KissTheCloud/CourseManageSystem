package com.ts.coursework.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ts.coursework.entity.Role;
import com.ts.coursework.entity.User;

@Mapper
public interface UserMapper {
	int addUser(User user);
	
	int delUserById(Long id);
	
	int updateUser(User user);
	
	User getUserById(Long id);
	
	List<User> getAllUser();
	//为用户添加角色
	int addRoleForUser(@Param("userId")Long userId,@Param("roleId")Integer roleId);
	//为用户删除所有角色
	int delRoleForUser(@Param("userId")Long userId);
	
	List<Role> getRolesByUserId(Long id);
	
	User getUserByName(String name);
	
	//根据课程获取管理员
	User getUserByCourseId(int courseId);
}
