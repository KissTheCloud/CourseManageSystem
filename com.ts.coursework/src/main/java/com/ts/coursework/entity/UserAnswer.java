package com.ts.coursework.entity;

public class UserAnswer {
	private int id;
	private long userId;
	private int examId;
	private int textId;
	private int examPaperId;
	private int subjectId;
	private int status;//0为未提交，1为已经提交，2为被打回。
	private float score;
	
	private Text text;
	private User user;
	private Exam exam;
	private ExamPaper examPaper;
	private Subject subject;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getTextId() {
		return textId;
	}
	public void setTextId(int textId) {
		this.textId = textId;
	}
	public int getExamPaperId() {
		return examPaperId;
	}
	public void setExamPaperId(int examPaperId) {
		this.examPaperId = examPaperId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Text getText() {
		return text;
	}
	
	public void setText(Text text) {
		this.text = text;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public ExamPaper getExamPaper() {
		return examPaper;
	}
	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
}
