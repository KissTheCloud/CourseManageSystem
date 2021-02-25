package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ts.coursework.entity.Course;
import com.ts.coursework.entity.User;

@Mapper
public interface CourseMapper {
	//添加课程
	int addCourse(Course course);
	//删除课程
	int delCourse(int id);
	//编辑课程
	int updateCourse(Course course);
	//通过加课码获取课程
	Course getCourseByJoinCode(String joinCode);
	//通过id获取课程
	Course getCourseById(int id);
	//获取用户的全部课程
	List<?extends Course> getCoursesByUserId(Long userId);
	//获取用户类型
	int getUserTypeByUserIdCourseId(@Param("userId") Long userId,@Param("courseId") int courseId);
	//获取成员数量
	int getMembersCount(int courseId);
	//通过加课码添加课程
	int addCourseByJoinCode(@Param("userId") Long userId,@Param("joinCourseCode") String joinCourseCode,@Param("index")int index,@Param("userType")int userType);
	//获取用户课程的最大indexs
	int getMaxUserCourseIndex(Long userId);
	//为用户添加课程
	int addCourseForUser(@Param("userId")Long userId,@Param("courseId")int courseId,@Param("index")int index,@Param("userType")int userType);
	//退选课程
	int quitCourse(@Param("userId")Long userId,@Param("courseId")int courseId);
	//归档课程
	int placeCourseOnFile(@Param("userId")Long userId,@Param("courseId")int courseId);
	//恢复归档课程
	int resumeCourseFromFile(@Param("userId")Long userId,@Param("courseId")int courseId);
	//获取归档的课程
	List<? extends Course> getPlaceCourseByUserId(Long userId);
	/*获取课程所有的学生*/
	List<User> getStusByCourseId(int courseId);
}
