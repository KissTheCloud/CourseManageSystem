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
import com.ts.coursework.dto.CourseDto;
import com.ts.coursework.entity.Course;
import com.ts.coursework.entity.User;
import com.ts.coursework.service.CourseService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@CrossOrigin
	@GetMapping("/getUserCourses")
	List<CourseDto> getCoursesByUserId(){
		//不用自己传入userId,因为security完成了操蛋的封装
		return courseService.getUserCourses();
	}
	
	@CrossOrigin
	@PostMapping("/addCourse")
	int addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@CrossOrigin
	@PostMapping("/updateCourse")
	int updateCourse(@RequestBody Course course) {
		return courseService.updateCourse(course);
	}
	
	@CrossOrigin
	@GetMapping("/delCourse")
	int delCourse(int id) {
		return courseService.delCourse(id);
	}
	
	@CrossOrigin
	@GetMapping("/quitCourse")
	int quitCourse(int courseId) {
		return courseService.quitCourse(courseId);
	}
	
	@CrossOrigin
	@GetMapping("/placeCourseOnFile")
	int placeCourseOnFile(int courseId) {
		return courseService.placeCourseOnFile(courseId);
	}
	
	@CrossOrigin
	@GetMapping("/resumeCourseFromFile")
	int resumeCourseFromFile(int courseId) {
		return courseService.resumeCourseFromFile(courseId);
	}
	
	@CrossOrigin
	@GetMapping("/getPlacedCourseByUserId")
	List<CourseDto> getPlacedCourseByUserId() {
		return courseService.getPlacedCourseByUserId();
	}
	
	@CrossOrigin
	@GetMapping("/addCourseByJoinCode")
	int addCourseByJoinCode(@RequestParam("joinCode") String joinCode) {
		return courseService.addCourseByJoinCode(joinCode);
	}
	
	@CrossOrigin
	@GetMapping("/getCourseById")
	CourseDto getCourseById(@RequestParam("courseId") int courseId ){
		 return courseService.getCourseById(courseId);
	}
	
	@CrossOrigin
	@GetMapping("/getCurrentUser")
	User getCurrentUser() {
		return courseService.getCurrentUser();
	}
}
