package com.ts.coursework.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.coursework.entity.Exam;
import com.ts.coursework.mapper.ExamMapper;
@Service
public class ExamService {
	
	@Autowired
	ExamMapper examMapper;
	
	public void add(Exam exam) {
		examMapper.add(exam);
	}
	
	public void del(int id) {
		examMapper.del(id);
	}
	
	public void update(Exam exam) {
		examMapper.update(exam);
	}
	
	public Exam get(int id) {
		return examMapper.get(id);
	}
	
	public List<Exam> getAll(){
		return examMapper.getAll();
	}
	
	public List<Exam> getBySubjectId(int subjectId){
		return examMapper.getBySubjectId(subjectId);
	}
	
	public List<Exam> getExamsByUserId(long userId){
		return examMapper.getExamsByUserId(userId);
	}
}
