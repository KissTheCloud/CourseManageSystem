package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ts.coursework.entity.Question;

@Mapper
public interface QuestionMapper {
	void addQuestion(Question question);
	void delQuestion(int id);
	void updateQuestion(Question question);
	Question getQuestionById(int id);
	List<Question> getAllQuestions();
	List<Question> getQuestionsByExamPaperId(int examPaperId);
	List<Question> getQuestionsBySubjectId(int subjectId);
}
