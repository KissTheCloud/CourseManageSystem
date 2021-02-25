package com.ts.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ts.coursework.entity.Question;
import com.ts.coursework.service.imp.QuestionService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@CrossOrigin
	@PostMapping("/addQuestion")
	void addQuestion(@RequestBody Question question) {
		questionService.addQuestion(question);
	}
	
	@GetMapping("/delQuestion")
	@CrossOrigin
	void delQuestion(int id) {
		questionService.delQuestion(id);
	}
	
	@PostMapping("/updateQuestion")
	@CrossOrigin
	void updateQuestion(@RequestBody Question question) {
		questionService.updateQuestion(question);
	}
	
	@GetMapping("/getQuestionById")
	@CrossOrigin
	Question getQuestionById(int id) {
		return questionService.getQuestionById(id);
	}
	
	@GetMapping("/getAllQuestions")
	@CrossOrigin
	List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/getQuestionsByExamPaperId")
	@CrossOrigin
	public List<Question> getQuestionsByExamPaperId(int examPaperId){
		return questionService.getQuestionsByExamPaperId(examPaperId);
	}
	
	@GetMapping("/getQuestionsBySubjectId")
	@CrossOrigin
	public List<Question> getQuestionsBySubjectId(int subjectId){
		return questionService.getQuestionsBySubjectId(subjectId);
	}
}
