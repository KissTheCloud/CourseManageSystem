package com.ts.coursework.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.coursework.entity.Epqm;
import com.ts.coursework.entity.ExamPaper;
import com.ts.coursework.entity.Question;
import com.ts.coursework.mapper.EpqmMapper;
import com.ts.coursework.mapper.ExamPaperMapper;
import com.ts.coursework.mapper.QuestionMapper;
import com.ts.coursework.mapper.TextMapper;

@Service
public class ExamPaperService {
	@Autowired
	ExamPaperMapper examPaperMapper;
	
	@Autowired
	EpqmMapper epqmMapper;
	@Autowired
	QuestionMapper questionMapper;
	
	@Autowired
	TextMapper textMapper;
	
	public  void addExamPaper(ExamPaper examPaper) {
		examPaperMapper.addExamPaper(examPaper);
		List<Question> questions=examPaper.getQuestions();
		if(questions==null) {
			questions=new ArrayList<Question>();
		}
		for(Question question:questions) {
			Epqm epqm=new Epqm();
			epqm.setExamPaperId(examPaper.getId());
			epqm.setQuestionId(question.getId());
			epqmMapper.add(epqm);
		}
	}
	public void delExamPaper(int id) {
		//数据库会自动删除对应的epqm
		examPaperMapper.delExamPaper(id);;
	}
	public void updateExamPaper(ExamPaper examPaper) {
		examPaperMapper.updateExamPaper(examPaper);
		//先删除所有映射，再添加
		epqmMapper.delByExamPaperId(examPaper.getId());
		List<Question> questions=examPaper.getQuestions();
		if(questions==null) {
			questions=new ArrayList<Question>();
		}
		for(Question question:questions) {
			Epqm epqm=new Epqm();
			epqm.setExamPaperId(examPaper.getId());
			epqm.setQuestionId(question.getId());
			epqmMapper.add(epqm);
		}
	}
	public ExamPaper getExamPaperById(int id) {
		ExamPaper examPaper=examPaperMapper.getExamPaperById(id);
		List<Question> questions=questionMapper.getQuestionsByExamPaperId(id);
		for(Question question:questions) {
			question.setContent(textMapper.getTextById(question.getContentId()));;
		}
		examPaper.setQuestions(questions);
		return examPaper;
	}
	public List<ExamPaper> getAllExamPaper(){
		List<ExamPaper> examPapers=examPaperMapper.getAllExamPaper();
		for(ExamPaper examPaper:examPapers) {
			List<Question> questions=questionMapper.getQuestionsByExamPaperId(examPaper.getId());
			examPaper.setQuestions(questions);
		}
		return examPapers;
	}
	public List<ExamPaper> getExamPaperBySubjectId(int subjectId){
		List<ExamPaper> examPapers=examPaperMapper.getExamPaperBySubjectId(subjectId);
		for(ExamPaper examPaper:examPapers) {
			List<Question> questions=questionMapper.getQuestionsByExamPaperId(examPaper.getId());
			examPaper.setQuestions(questions);
		}
		return examPapers;
	}
}
