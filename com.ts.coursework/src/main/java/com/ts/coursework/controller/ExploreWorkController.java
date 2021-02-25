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

import com.ts.coursework.dto.ExploreWorkDto;
import com.ts.coursework.entity.ExploreWork;
import com.ts.coursework.service.ExploreWorkService;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/exploreWork")
public class ExploreWorkController {
	
	@Autowired
	ExploreWorkService exploreWorkService;
	
	@CrossOrigin
	@GetMapping("/getExploreWorkByCourseId")
	List<ExploreWorkDto> getExploreWorkByCourseId(@RequestParam("courseId")int courseId){
		return exploreWorkService.getExploreWorksByCourseId(courseId);
	}
	
	@CrossOrigin
	@PostMapping("/addExploreWork")
	int addExploreWork(@RequestBody ExploreWork exploreWork) {
		return exploreWorkService.addExploreWork(exploreWork);
	}
	
	@CrossOrigin
	@PostMapping("/updateExploreWork")
	int updateExploreWork(@RequestBody ExploreWork exploreWork) {
		return exploreWorkService.updateExploreWork(exploreWork);
	}
	
	@CrossOrigin
	@GetMapping("/delExploreWork")
	int delExploreWork(@RequestParam("exploreWorkId") int exploreWorkId) {
		return exploreWorkService.delExploreWork(exploreWorkId);
	}
	
	@CrossOrigin
	@GetMapping("/getExploreWorkById")
	ExploreWork getExploreWorkById(@RequestParam("exploreWorkId") int exploreWorkId) {
		return exploreWorkService.getExploreWorkById(exploreWorkId);
	}
}
