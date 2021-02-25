package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ts.coursework.entity.Exam;
@Mapper
public interface ExamMapper {
	void add(Exam exam);
	
	void del(int id);
	
	void update(Exam exam);
	
	Exam get(int id);
	
	List<Exam> getAll();
	
	List<Exam> getBySubjectId(int subjectId);
	
	/**
	 * ！！！这个方法可能有问题，不要用
	 * @param userId
	 * @return
	 */
	List<Exam> getExamsByUserId(long userId);
}
