package com.ts.coursework.entity;

import java.sql.Timestamp;

/**
 * 学生提交的作业
 * @author ts
 *
 */
public class SubmitWork {
	private int id;
	private Long userId;
	private int score;
	private int exploreWorkId;
	private Timestamp submitTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getExploreWorkId() {
		return exploreWorkId;
	}
	public void setExploreWorkId(int exploreWorkId) {
		this.exploreWorkId = exploreWorkId;
	}
	public Timestamp getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}
}
