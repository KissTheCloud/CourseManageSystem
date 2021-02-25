package com.ts.coursework.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ts.coursework.dto.SubmitWorkDto;
import com.ts.coursework.entity.SubmitWork;
import com.ts.coursework.entity.SubmitWorkFile;
import com.ts.coursework.entity.User;
import com.ts.coursework.entity.WorkFile;
import com.ts.coursework.mapper.FileMapper;
import com.ts.coursework.mapper.SubmitWorkMapper;
import com.ts.coursework.mapper.UserMapper;
import com.ts.coursework.service.SubmitWorkService;

@Service
public class SubmitWorkServiceImp implements SubmitWorkService {
	
	@Autowired
	SubmitWorkMapper submitWorkMapper;
	@Autowired
	FileMapper fileMapper;
	@Autowired
	UserMapper userMapper;

	@Override
	public SubmitWorkDto getSubmitWork(int exploreWorkId) {
		SubmitWork submitWork=submitWorkMapper.getSubmitWork(exploreWorkId, this.getCurrentUser().getId());
		SubmitWorkDto submitWorkDto=new SubmitWorkDto(submitWork);
		
		submitWorkDto.setSubmitWorkFiles(fileMapper.getSubmitWorkFiles(submitWork.getId()));
		List<WorkFile> workFiles=new ArrayList<WorkFile>();
		if(submitWorkDto.getSubmitWorkFiles()!=null) {
			for(SubmitWorkFile submitWorkFile:submitWorkDto.getSubmitWorkFiles()) {
				workFiles.add(fileMapper.getWorkFileById(submitWorkFile.getWorkFileId()));
			}
		}
		submitWorkDto.setWorkFiles(workFiles);
		return submitWorkDto;
	}

	@Override
	public List<? extends SubmitWorkDto> getSubmitWorksByExploreWorkId(int exploreWorkId) {
		List<? extends SubmitWork> submitWorks=submitWorkMapper.getSubmitWorksByExploreWorkId(exploreWorkId);
		List<SubmitWorkDto> submitWorkDtos=new ArrayList<SubmitWorkDto>();
		for(SubmitWork submitWork:submitWorks) {
			SubmitWorkDto submitWorkDto=new SubmitWorkDto(submitWork);
			//设置文件
			submitWorkDto.setSubmitWorkFiles(fileMapper.getSubmitWorkFiles(submitWork.getId()));
			List<WorkFile> workFiles=new ArrayList<WorkFile>();
			if(submitWorkDto.getSubmitWorkFiles()!=null) {
				for(SubmitWorkFile submitWorkFile:submitWorkDto.getSubmitWorkFiles()) {
					workFiles.add(fileMapper.getWorkFileById(submitWorkFile.getWorkFileId()));
				}
			}
			submitWorkDto.setWorkFiles(workFiles);
			//设置学生
			submitWorkDto.setStudent(userMapper.getUserById(submitWork.getUserId()));
			submitWorkDtos.add(submitWorkDto);
		}
		return submitWorkDtos;
	}

	/*目前没用*/
	@Override
	public int addSubmitWork(int exploreWorkId, Long userId) {
		
		SubmitWork submitWork=new SubmitWork();;
		submitWork.setExploreWorkId(exploreWorkId);
		submitWork.setUserId(userId);
		submitWorkMapper.addSubmitWork(submitWork);
		return submitWork.getId();
	}
	
	private User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
}
