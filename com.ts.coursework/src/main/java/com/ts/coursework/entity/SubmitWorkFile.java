package com.ts.coursework.entity;

/**
 * 学生提交作业对应的文件映射
 * @author ts
 *
 */
public class SubmitWorkFile {
	private int id;
	private int submitWorkId;
	private int workFileId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubmitWorkId() {
		return submitWorkId;
	}
	public void setSubmitWorkId(int submitWorkId) {
		this.submitWorkId = submitWorkId;
	}
	public int getWorkFileId() {
		return workFileId;
	}
	public void setWorkFileId(int workFileId) {
		this.workFileId = workFileId;
	}
}
