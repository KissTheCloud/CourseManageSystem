package com.ts.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ts.coursework.dto.SubmitWorkDto;
import com.ts.coursework.service.SubmitWorkService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/submitWork")
public class SubmitWorkController {
	@Autowired
	SubmitWorkService submitWorkService;
	
	@CrossOrigin
	@GetMapping("/getSubmitWork")
	SubmitWorkDto getSubmitWork(@RequestParam("exploreWorkId")int exploreWorkId){
		return  submitWorkService.getSubmitWork(exploreWorkId);
	}
	
	@CrossOrigin
	@GetMapping("/getSubmitWorksByExploreWorkId")
	List<? extends SubmitWorkDto> getSubmitWorksByExploreWorkId(@RequestParam("exploreWorkId")int exploreWorkId){
		return  submitWorkService.getSubmitWorksByExploreWorkId(exploreWorkId);
	}
}
