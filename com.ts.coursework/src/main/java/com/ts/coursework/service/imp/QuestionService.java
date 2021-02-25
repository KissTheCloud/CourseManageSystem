package com.ts.coursework.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.coursework.entity.Question;
import com.ts.coursework.entity.Subject;
import com.ts.coursework.entity.Text;
import com.ts.coursework.mapper.QuestionMapper;
import com.ts.coursework.mapper.SubjectMapper;
import com.ts.coursework.mapper.TextMapper;

@Service
public class QuestionService {
	@Autowired
	QuestionMapper questionMapper;
	
	@Autowired
	TextMapper textMapper;
	
	@Autowired
	SubjectMapper subjectMapper;
	
	public void addQuestion(Question question) {
		Text content=question.getContent();
		textMapper.addText(content);
		question.setContentId(content.getId());
		questionMapper.addQuestion(question);
	}
	public void delQuestion(int id) {
		Question question=questionMapper.getQuestionById(id);
		int contentId=question.getContentId();
		textMapper.delText(contentId);
		questionMapper.delQuestion(id);
	}
	public 	void updateQuestion(Question question) {
		Text content=question.getContent();
		textMapper.updateText(content);
		questionMapper.updateQuestion(question);
	}
	public Question getQuestionById(int id) {
		Question question= questionMapper.getQuestionById(id);
		Text text=textMapper.getTextById(question.getContentId());
		question.setContent(text);
		Subject subject=subjectMapper.getSubjectById(question.getSubjectId());
		question.setSubject(subject);
		return question;
	}
	public List<Question> getAllQuestions() {
		List<Question> questions= questionMapper.getAllQuestions();
		for(Question question:questions) {
			Text text=textMapper.getTextById(question.getContentId());
			question.setContent(text);
			Subject subject=subjectMapper.getSubjectById(question.getSubjectId());
			question.setSubject(subject);
		}
		return questions;
	}
	
	public List<Question> getQuestionsByExamPaperId(int examPaperId){
		List<Question> questions= questionMapper.getQuestionsByExamPaperId(examPaperId);
		for(Question question:questions) {
			Text text=textMapper.getTextById(question.getContentId());
			question.setContent(text);
			Subject subject=subjectMapper.getSubjectById(question.getSubjectId());
			question.setSubject(subject);
		}
		return questions;
	}
	
	public List<Question> getQuestionsBySubjectId(int subjectId){
		List<Question> questions= questionMapper.getQuestionsBySubjectId(subjectId);
		for(Question question:questions) {
			Text text=textMapper.getTextById(question.getContentId());
			question.setContent(text);
			Subject subject=subjectMapper.getSubjectById(question.getSubjectId());
			question.setSubject(subject);
		}
		return questions;
	}
}
