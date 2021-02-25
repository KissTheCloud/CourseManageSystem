package com.ts.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ts.coursework.dto.UserDto;
import com.ts.coursework.entity.Exam;
import com.ts.coursework.service.imp.ExamService;
import com.ts.coursework.service.imp.UserService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/exam")
public class ExamController {
	@Autowired
	ExamService examService;
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@PostMapping("/add")
	public void add(@RequestBody Exam exam) {
		examService.add(exam);
	}
	@CrossOrigin
	@GetMapping("/del")
	public void del(int id) {
		examService.del(id);
	}

	
	@CrossOrigin
	@PostMapping("/update")
	public void update(@RequestBody Exam exam) {
		examService.update(exam);
	}
	@CrossOrigin
	@GetMapping("/get")
	public Exam get(int id) {
		return examService.get(id);
	}
	@CrossOrigin
	@GetMapping("/getAll")
	public List<Exam> getAll(){
		return examService.getAll();
	}
	@CrossOrigin
	@GetMapping("/getBySubjectId")
	public List<Exam> getBySubjectId(int subjectId){
		return examService.getBySubjectId(subjectId);
	}
	
	@CrossOrigin
	@GetMapping("/getExamsByUserId")
	public List<Exam> getExamsByUserId(){
		//不用手动传入用户id，系统会自己获取
		UserDto userDto=userService.getCurrentUser();
		return examService.getExamsByUserId(userDto.getId());
	}
}
