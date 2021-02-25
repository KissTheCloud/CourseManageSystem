package com.ts.coursework.dto;

import java.util.List;

import com.ts.coursework.entity.SubmitWork;
import com.ts.coursework.entity.SubmitWorkFile;
import com.ts.coursework.entity.User;
import com.ts.coursework.entity.WorkFile;

public class SubmitWorkDto extends SubmitWork{
	
	List<? extends SubmitWorkFile> submitWorkFiles;
	
	List<WorkFile> workFiles;
	
	User student;
	
	public SubmitWorkDto(SubmitWork submitWork) {
		this.setId(submitWork.getId());
		this.setUserId(submitWork.getUserId());
		this.setScore(submitWork.getScore());
		this.setExploreWorkId(submitWork.getExploreWorkId());
		this.setSubmitTime(submitWork.getSubmitTime());
	}

	public List<? extends SubmitWorkFile> getSubmitWorkFiles() {
		return submitWorkFiles;
	}

	public void setSubmitWorkFiles(List<? extends SubmitWorkFile> submitWorkFiles) {
		this.submitWorkFiles = submitWorkFiles;
	}

	public List<WorkFile> getWorkFiles() {
		return workFiles;
	}

	public void setWorkFiles(List<WorkFile> workFiles) {
		this.workFiles = workFiles;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}
}
