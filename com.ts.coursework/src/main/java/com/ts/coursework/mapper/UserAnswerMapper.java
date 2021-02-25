package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ts.coursework.entity.UserAnswer;

@Mapper
public interface UserAnswerMapper {
	void add(UserAnswer userAnswer);

	void del(int id);

	void update(UserAnswer userAnswer);

	UserAnswer get(int id);
	
	List<UserAnswer> getByUserId(long userId);
	
	List<UserAnswer> getByUserIdAndExamPaperId(@Param("userId")long userId,@Param("examPaperId")int examPaperId);
	
	void delByUserIdAndExamId(@Param("userId")long userId,@Param("examId")int examId);
	
	UserAnswer getByUserIdAndExamId(@Param("userId") long userId,@Param("examId")int examId);
	
	
	List<UserAnswer> getByExamId(long examId);
}
