package com.ts.coursework.service;

import java.util.List;

import com.ts.coursework.dto.CourseDto;
import com.ts.coursework.entity.Course;
import com.ts.coursework.entity.User;

public interface CourseService {
	List<CourseDto> getUserCourses();
	int addCourse(Course course);
	int delCourse(int id);
	int updateCourse(Course course);
	int addCourseByJoinCode(String joinCourseCode);
	CourseDto getCourseById(int CourseId);
	User getCurrentUser();//这个不能删，操蛋的写法
	int quitCourse(int courseId);
	int placeCourseOnFile(int courseId);
	int resumeCourseFromFile(int courseId);
	List<CourseDto> getPlacedCourseByUserId();
}
