package com.ts.coursework.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.coursework.entity.Subject;
import com.ts.coursework.mapper.SubjectMapper;

@Service
public class SubjectService {

	@Autowired
	public SubjectMapper subjectMapper;
	
	public void addSubject(Subject subject) {
		subjectMapper.addSubject(subject);
	}
	public void delSubject(int id) {
		subjectMapper.delSubject(id);
	}
	public void updateSubject(Subject subject) {
		subjectMapper.updateSubject(subject);
	}
	public Subject getSubjectById(int id) {
	 return 	subjectMapper.getSubjectById(id);
	}
	
	public List<Subject> getAllSubjects(){
		return subjectMapper.getAllSubjects();
	}
}
