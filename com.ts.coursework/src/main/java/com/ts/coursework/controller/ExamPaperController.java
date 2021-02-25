package com.ts.coursework.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ts.coursework.entity.ExamPaper;
import com.ts.coursework.service.imp.ExamPaperService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/examPaper")
public class ExamPaperController {
	@Autowired
	ExamPaperService examPaperService;
	
	@CrossOrigin
	@PostMapping("/addExamPaper")
	void addExamPaper(@RequestBody ExamPaper examPaper) {
		examPaperService.addExamPaper(examPaper);
	}
	
	@CrossOrigin
	@GetMapping("/delExamPaper")
	void delExamPaper(int id) {
		//数据库会自动删除对应的epqm
		examPaperService.delExamPaper(id);;
	}
	
	@CrossOrigin
	@PostMapping("/updateExamPaper")
	void updateExamPaper(@RequestBody ExamPaper examPaper) {
		examPaperService.updateExamPaper(examPaper);
	}
	
	@CrossOrigin
	@GetMapping("/getExamPaperById")
	ExamPaper getExamPaperById(int id) {
		return examPaperService.getExamPaperById(id);
	}
	
	@CrossOrigin
	@GetMapping("/getAllExamPaper")
	List<ExamPaper> getAllExamPaper(){
		return examPaperService.getAllExamPaper();
	}
	
	@CrossOrigin
	@GetMapping("/getExamPaperBySubjectId")
	List<ExamPaper> getExamPaperBySubjectId(int subjectId){
		return examPaperService.getExamPaperBySubjectId(subjectId);
	}
}
