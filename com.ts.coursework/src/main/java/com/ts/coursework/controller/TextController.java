package com.ts.coursework.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ts.coursework.entity.Text;
import com.ts.coursework.service.imp.TextService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/text")
public class TextController {
	@Autowired
	TextService textService;
	
	@CrossOrigin
	@PostMapping("/addText")
	int addQuestion(@RequestBody Text text) {
		return textService.addText(text);
	}
	
	@GetMapping("/delText")
	@CrossOrigin
	void delQuestion(int id) {
		textService.delText(id);
	}
	
	@PostMapping("/updateText")
	@CrossOrigin
	void updateText(@RequestBody Text text) {
		textService.updateText(text);
	}
	
	@GetMapping("/getTextById")
	@CrossOrigin
	Text getTextById(int id) {
		return textService.getTextById(id);
	}
	
	@GetMapping("/getAllTexts")
	@CrossOrigin
	List<Text> getAllQuestions() {
		return textService.getAllTexts();
	}
}
