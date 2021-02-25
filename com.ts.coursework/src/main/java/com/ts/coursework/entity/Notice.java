package com.ts.coursework.entity;

import java.sql.Timestamp;

/**
 * 通知类，包括催交通知，作业发布通知等
 * @author ts
 *
 */
public class Notice {
	private int id;
	private int type;//0为催交，1为作业发布通知
	private int times;//次数
	private boolean isTop;//是否置顶，如果置顶将通知接受用户，并改为未置顶
	private Timestamp date;//发布时间
	private String content;
	private Long userFromId;
	private Long userToId;
	private int workId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public boolean isTop() {
		return isTop;
	}
	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserFromId() {
		return userFromId;
	}
	public void setUserFromId(Long userFromId) {
		this.userFromId = userFromId;
	}
	public Long getUserToId() {
		return userToId;
	}
	public void setUserToId(Long userToId) {
		this.userToId = userToId;
	}
	public int getWorkId() {
		return workId;
	}
	public void setWorkId(int workId) {
		this.workId = workId;
	}
	
}
