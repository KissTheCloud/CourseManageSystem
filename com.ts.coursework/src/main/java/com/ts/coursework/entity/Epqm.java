package com.ts.coursework.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class Epqm {
	private int examPaperId;
	private int questionId;
	private int id;
	public int getExamPaperId() {
		return examPaperId;
	}
	public void setExamPaperId(int examPaperId) {
		this.examPaperId = examPaperId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}	
