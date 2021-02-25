package com.ts.coursework.dto;

import java.util.List;

import com.ts.coursework.entity.Course;
import com.ts.coursework.entity.ExploreWork;
import com.ts.coursework.entity.User;

public class CourseDto extends Course {
	private int userType;
	
	private int memberCount;
	
	private List<ExploreWork> exploreWorks;
	//创建者
	private User admin;

	public CourseDto() {
		
	}
	
	public CourseDto(Course course) {
		this.setId(course.getId());
		this.setName(course.getName());
		this.setClassName(course.getClassName());
		this.setSchoolYear(course.getSchoolYear());
		this.setSemester(course.getSemester());
		this.setJoinCode(course.getJoinCode());
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public List<ExploreWork> getExploreWorks() {
		return exploreWorks;
	}

	public void setExploreWorks(List<ExploreWork> exploreWorks) {
		this.exploreWorks = exploreWorks;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	
}	
