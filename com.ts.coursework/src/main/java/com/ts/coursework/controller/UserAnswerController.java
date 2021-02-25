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
import com.ts.coursework.entity.User;
import com.ts.coursework.entity.UserAnswer;
import com.ts.coursework.service.imp.UserAnswerService;
import com.ts.coursework.service.imp.UserService;


@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("userAnswer")
public class UserAnswerController {
	@Autowired
	UserAnswerService userAnswerService;
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@PostMapping("/add")
	void add(@RequestBody UserAnswer userAnswer) {
		userAnswerService.add(userAnswer);
	}

	@CrossOrigin
	@GetMapping("/del")
	void del(int id) {
		userAnswerService.del(id);
	}
	
	@CrossOrigin
	@GetMapping("/delByUserIdAndExamId")
	public void delByUserIdAndExamId(int examId) {
		long userId=userService.getCurrentUser().getId();
		userAnswerService.delByUserIdAndExamId(userId,examId);
	}

	@CrossOrigin
	@PostMapping("/update")
	void update(@RequestBody UserAnswer userAnswer) {
		userAnswerService.update(userAnswer);
	}

	@CrossOrigin
	@GetMapping("/get")
	UserAnswer get(int id) {
		return userAnswerService.get(id);
	}
	
	@CrossOrigin
	@GetMapping("/getByUserId")
	List<UserAnswer> getByUserId(){
		User user= userService.getCurrentUser();
		return userAnswerService.getByUserId(user.getId());
	}
	
	@CrossOrigin
	@GetMapping("/getByUserIdAndExamPaperId")
	List<UserAnswer> getByUserIdAndExamPaperId(@RequestParam("examPaperId")int examPaperId){
		User user= userService.getCurrentUser();
		return userAnswerService.getByUserIdAndExamPaperId(user.getId(),examPaperId);
	}
	
	@CrossOrigin
	@GetMapping("/getByExamId")
	List<UserAnswer> getByExamId(@RequestParam("examId")int examId){
		return userAnswerService.getByExamId(examId);
	}
}
