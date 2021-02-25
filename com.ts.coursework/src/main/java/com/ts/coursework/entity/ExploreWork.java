package com.ts.coursework.entity;

import java.sql.Timestamp;

/**
 * 教师发布的作业
 * @author ts
 *
 */
public class ExploreWork {
	private int id;
	private String name;
	private String content;
	private Timestamp exploreTime;
	private Timestamp endTime;
	private int courseId;
	private int fullScore;
	private Long userId;
	
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
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getExploreTime() {
		return exploreTime;
	}
	
	public void setExploreTime(Timestamp exploreTime) {
		this.exploreTime = exploreTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	public int getFullScore() {
		return fullScore;
	}
	
	public void setFullScore(int fullScore) {
		this.fullScore = fullScore;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
