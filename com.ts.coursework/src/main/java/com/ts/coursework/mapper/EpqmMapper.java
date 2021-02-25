package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ts.coursework.entity.Epqm;

/**
 * 卷子与题目的映射表
 * 
 * @author Ts
 *
 */
@Mapper
public interface EpqmMapper {
	void add(Epqm epqm);

	void del(int id);

	void update(Epqm epqm);

	Epqm get(int id);
	
	void delByExamPaperId(int examPaperId);
	
	List<Epqm> getByExamIdAndQuestionId(@Param("examId") int examId,@Param("question") int question);
	
}
