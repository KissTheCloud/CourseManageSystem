package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ts.coursework.entity.Subject;

@Mapper
public interface SubjectMapper {
	void addSubject(Subject subject);
	void delSubject(int id);
	void updateSubject(Subject subject);
	Subject getSubjectById(int id);
	List<Subject> getAllSubjects();
}
