package com.ts.coursework.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.ts.coursework.dto.CourseDto;
import com.ts.coursework.entity.Course;
import com.ts.coursework.entity.ExploreWork;
import com.ts.coursework.entity.SubmitWork;
import com.ts.coursework.entity.User;
import com.ts.coursework.mapper.CourseMapper;
import com.ts.coursework.mapper.ExploreWorkMapper;
import com.ts.coursework.mapper.SubmitWorkMapper;
import com.ts.coursework.mapper.UserMapper;
import com.ts.coursework.service.CourseService;
import com.ts.coursework.util.CodeCreater;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	CourseMapper courseMapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	ExploreWorkMapper exploreWorkMapper;

	@Autowired
	SubmitWorkMapper submitWorkMapper;

	public User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	private String createUniqueJoinCode() {
		String uniqueCode;
		while (true) {
			uniqueCode = CodeCreater.createCode(6);
			if (courseMapper.getCourseByJoinCode(uniqueCode) == null) {
				return uniqueCode;
			}
		}
	}

	/* 课程排序 */
	private int getMaxUserCourseIndex(Long userId) {
		return courseMapper.getMaxUserCourseIndex(userId);
	}

	@Override
	public List<CourseDto> getUserCourses() {
		User user = this.getCurrentUser();
		List<? extends Course> courses = courseMapper.getCoursesByUserId(user.getId());
		List<CourseDto> courseDtos = new ArrayList<CourseDto>();
		for (Course course : courses) {
			CourseDto courseDto = new CourseDto(course);
			// 为课程设置用户类型
			courseDto.setUserType(courseMapper.getUserTypeByUserIdCourseId(user.getId(), courseDto.getId()));
			// 为课程设置管理员
			courseDto.setAdmin(userMapper.getUserByCourseId(courseDto.getId()));
			// 设置成员数量
			courseDto.setMemberCount(courseMapper.getMembersCount(courseDto.getId()));
			// 设置发布的作业
			courseDto.setExploreWorks(exploreWorkMapper.getExploreWorksByCourseId(courseDto.getId()));
			courseDtos.add(courseDto);
		}
		return courseDtos;
	}

	@Override
	public int addCourse(Course course) {

		// 生成加课码
		course.setJoinCode(this.createUniqueJoinCode());
		// 添加课程
		courseMapper.addCourse(course);
		// 添加管理员
		User user = this.getCurrentUser();
		course = courseMapper.getCourseByJoinCode(course.getJoinCode());
		courseMapper.addCourseForUser(user.getId(), course.getId(), this.getMaxUserCourseIndex(user.getId()) + 1, 2);
		return 1;
	}

	@Override
	public int delCourse(int id) {
		return courseMapper.delCourse(id);
	}

	@Override
	public int updateCourse(Course course) {
		return courseMapper.updateCourse(course);
	}

	/*
	 * 学生添加课程
	 */
	@Override
	public int addCourseByJoinCode(String joinCourseCode) {
		User user = this.getCurrentUser();

		// 检查是否已经存在该课程

		courseMapper.addCourseByJoinCode(user.getId(), joinCourseCode, this.getMaxUserCourseIndex(user.getId()) + 1, 0);
		Course course = courseMapper.getCourseByJoinCode(joinCourseCode);
		// 添加submitWork
		List<ExploreWork> exploreWorks = exploreWorkMapper.getExploreWorksByCourseId(course.getId());
		for (ExploreWork exploreWork : exploreWorks) {
			SubmitWork submitWork = new SubmitWork();
			submitWork.setUserId(this.getCurrentUser().getId());
			submitWork.setExploreWorkId(exploreWork.getId());
			submitWorkMapper.addSubmitWork(submitWork);
		}
		return 1;
	}

	public CourseDto getCourseById(int courseId) {
		User user = this.getCurrentUser();
		CourseDto courseDto = new CourseDto(courseMapper.getCourseById(courseId));
		// 为课程设置用户类型
		courseDto.setUserType(courseMapper.getUserTypeByUserIdCourseId(user.getId(), courseDto.getId()));
		// 为课程设置管理员
		courseDto.setAdmin(userMapper.getUserByCourseId(courseDto.getId()));
		// 设置成员数量
		courseDto.setMemberCount(courseMapper.getMembersCount(courseDto.getId()));
		return courseDto;
	}

	@Override
	public int quitCourse(int courseId) {
		courseMapper.quitCourse(this.getCurrentUser().getId(), courseId);
		return 0;
	}

	@Override
	public int placeCourseOnFile(int courseId) {
		courseMapper.placeCourseOnFile(this.getCurrentUser().getId(), courseId);
		return 0;
	}

	@Override
	public int resumeCourseFromFile(int courseId) {
		courseMapper.resumeCourseFromFile(this.getCurrentUser().getId(), courseId);
		return 0;
	}

	@Override
	public List<CourseDto> getPlacedCourseByUserId() {
		List<? extends Course> courses = courseMapper.getPlaceCourseByUserId(this.getCurrentUser().getId());
		List<CourseDto> courseDtos = new ArrayList<CourseDto>();
		User user = this.getCurrentUser();
		for (Course course : courses) {
			CourseDto courseDto = new CourseDto(course);
			// 为课程设置用户类型
			courseDto.setUserType(courseMapper.getUserTypeByUserIdCourseId(user.getId(), courseDto.getId()));
			courseDtos.add(courseDto);
		}
		return courseDtos;
	}
}
