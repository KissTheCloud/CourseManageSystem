package com.ts.coursework.entity;


/**
 * 课程
 * @author Administrator
 *
 */
public class Course {
	private int id;
	private String name;
	private String className;
	private String schoolYear;
	private int semester;
	private String joinCode;
	
	public Course() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSchoolYear() {
		return schoolYear;
	}
	
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public String getJoinCode() {
		return joinCode;
	}
	
	public void setJoinCode(String joinCode) {
		this.joinCode = joinCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
