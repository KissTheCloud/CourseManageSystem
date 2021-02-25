package com.ts.coursework.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.ts.coursework.dto.ExploreWorkFileDto;
import com.ts.coursework.dto.SubmitWorkFileDto;
import com.ts.coursework.service.FileService;

/**
 * 所有文件相关的操作都在这里执行
 * @author TS
 *
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	FileService fileService;
	
	@CrossOrigin
	@GetMapping("/getExploreWorkFiles")
	List<ExploreWorkFileDto> getExploreWorkFiles(@RequestParam("exploreWorkId")int exploreWorkId){
		return fileService.getExploreWorkFiles(exploreWorkId);
	}
	
	@CrossOrigin
	@GetMapping("getSubmitWorkFiles")
	List<SubmitWorkFileDto> getSubmitWorkFiles(@RequestParam("submitWorkId")int submitWorkId){
		return fileService.getSubmitWorkFiles(submitWorkId);
	}
	
	@CrossOrigin
	@PostMapping("uploadSubWorkFile")
	@ResponseBody
	List<Integer> uploadSubWorkFile(MultipartHttpServletRequest request){
		return fileService.uploadSubWorkFile(request);
	}
	
	@CrossOrigin
	@PostMapping("uploadExpWorkFile")
	@ResponseBody
	List<Integer> uploadExpWorkFile(MultipartHttpServletRequest request){
		return fileService.uploadExpWorkFile(request);
	}
	
	@CrossOrigin
	@GetMapping("uploadExploreWorkFile")
	int uploadExploreWorkFile(@RequestParam("exploreWorkId")int exploreWorkId,@RequestParam("workFileId")int workFileId){
		return fileService.uploadExploreWorkFile(exploreWorkId, workFileId);
	}
	
	@CrossOrigin
	@GetMapping("uploadSubmitWorkFile")
	int uploadSubmitWorkFile(@RequestParam("submitWorkId")int submitWorkId,@RequestParam("workFileId")int workFileId){
		return fileService.uploadSubmitWorkFile(submitWorkId, workFileId);
	}
	
	@CrossOrigin
	@GetMapping("delExpWorkFile")
	int delExpWorkFile(@RequestParam("workFileId")int workFileId){
		return fileService.delExpWorkFile(workFileId);
	}
	
	@CrossOrigin
	@GetMapping("delSubWorkFile")
	int delSubWorkFile(@RequestParam("workFileId")int workFileId){
		return fileService.delSubWorkFile(workFileId);
	}
	
	@CrossOrigin
	@GetMapping("downloadExpWorkFile")
	@ResponseBody
	void downloadExpWorkFile(@RequestParam("path")String saveName,HttpServletResponse response){
		fileService.downloadExpFile(saveName, response);
	}
	
	@CrossOrigin
	@GetMapping("downloadSubWorkFile")
	@ResponseBody
	void downloadSubWorkFile(@RequestParam("path")String saveName,HttpServletResponse response){
		fileService.downloadSubFile(saveName, response);
	}
}
