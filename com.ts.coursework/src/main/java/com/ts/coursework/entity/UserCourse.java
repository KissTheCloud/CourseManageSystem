package com.ts.coursework.entity;
/**
 * 用户和课程的映射表
 * @author ts
 *
 */
public class UserCourse {
	private int id;
	//课程在用户所有课程中的序号，用于排序
	private int index;
	private Long userId;
	private int courseId;
	//用户类型，0代表学生，1代表老师，2代表助教
	private int userType;
	//是否归档，0未归档，1归档
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
