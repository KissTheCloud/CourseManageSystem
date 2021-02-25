package com.ts.coursework.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ts.coursework.entity.Subject;
import com.ts.coursework.service.imp.SubjectService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	public SubjectService subjectService;
	
	@CrossOrigin
	@PostMapping("/addSubject")
	public void addSubject(@RequestBody Subject subject) {
		subjectService.addSubject(subject);
	}
	
	@CrossOrigin
	@GetMapping("/delSubject")
	public void delSubject(@RequestParam("id") int id) {
		subjectService.delSubject(id);
	}
	
	@CrossOrigin
	@PostMapping("/updateSubject")
	public void updateSubject(@RequestBody Subject subject) {
		subjectService.updateSubject(subject);
	}
	
	@CrossOrigin
	@GetMapping("/getSubjectById")
	public Subject getSubjectById(@RequestParam("id") int id) {
	 return 	subjectService.getSubjectById(id);
	}
	
	@CrossOrigin
	@GetMapping("/getAllSubjects")
	public List<Subject> getAllSubjects(){
		return subjectService.getAllSubjects();
	}
}
