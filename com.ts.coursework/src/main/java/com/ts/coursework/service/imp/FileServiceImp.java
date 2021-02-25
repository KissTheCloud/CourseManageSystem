package com.ts.coursework.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.ts.coursework.dto.ExploreWorkFileDto;
import com.ts.coursework.dto.SubmitWorkFileDto;
import com.ts.coursework.entity.ExploreWorkFile;
import com.ts.coursework.entity.SubmitWorkFile;
import com.ts.coursework.entity.WorkFile;
import com.ts.coursework.mapper.FileMapper;
import com.ts.coursework.service.FileService;
import com.ts.coursework.util.FileHelper;
@Service
public class FileServiceImp implements FileService {

	@Autowired
	FileMapper fileMapper;
	
	@Override
	public List<ExploreWorkFileDto> getExploreWorkFiles(int exploreWorkId) {
		List<? extends ExploreWorkFile> exploreWorkFiles= fileMapper.getExploreWorkFiles(exploreWorkId);
		List<ExploreWorkFileDto>  exploreWorkFileDtos=new ArrayList<ExploreWorkFileDto>();
		for(ExploreWorkFile exploreWorkFile:exploreWorkFiles) {
			ExploreWorkFileDto exploreWorkFileDto=new ExploreWorkFileDto(exploreWorkFile);
			exploreWorkFileDto.setWorkFile(fileMapper.getWorkFileById(exploreWorkFileDto.getWorkFileId()));
			exploreWorkFileDtos.add(exploreWorkFileDto);
		}
		return exploreWorkFileDtos;
	}

	@Override
	public List<SubmitWorkFileDto> getSubmitWorkFiles(int submitWorkId) {
		List<? extends SubmitWorkFile> submitWorkFiles= fileMapper.getSubmitWorkFiles(submitWorkId);
		List<SubmitWorkFileDto>  submitWorkFileDtos=new ArrayList<SubmitWorkFileDto>();
		for(SubmitWorkFile submitWorkFile:submitWorkFiles) {
			SubmitWorkFileDto submitWorkFileDto=new SubmitWorkFileDto(submitWorkFile);
			submitWorkFileDto.setWorkFile(fileMapper.getWorkFileById(submitWorkFileDto.getWorkFileId()));
			submitWorkFileDtos.add(submitWorkFileDto);
		}
		return submitWorkFileDtos;
	}

	@Override
	public List<Integer> uploadSubWorkFile(MultipartHttpServletRequest request) {
		List<MultipartFile> files=request.getFiles("file");
		List<Integer> workFileIds=new ArrayList<Integer>();
		for(MultipartFile file:files) {
			String saveName= FileHelper.uploadFile(file,FileHelper.submitWorkFilePath);
			fileMapper.uploadWorkFile(file.getOriginalFilename(), saveName);
			WorkFile workFile= fileMapper.getWorkFileByPath(saveName);
			workFileIds.add(workFile.getId());
		}
		return workFileIds;
	}
	
	@Override
	public List<Integer> uploadExpWorkFile(MultipartHttpServletRequest request) {
		List<MultipartFile> files=request.getFiles("file");
		List<Integer> workFileIds=new ArrayList<Integer>();
		for(MultipartFile file:files) {
			String saveName= FileHelper.uploadFile(file,FileHelper.exploreWorkFilePath);
			fileMapper.uploadWorkFile(file.getOriginalFilename(), saveName);
			WorkFile workFile=fileMapper.getWorkFileByPath(saveName);
			workFileIds.add(workFile.getId());
		}
		return workFileIds;
	}

	@Override
	public int uploadExploreWorkFile(int exploreWorkId, int workFileId) {
		return fileMapper.uploadExploreWorkFile(exploreWorkId, workFileId);
	}

	@Override
	public int uploadSubmitWorkFile(int submitWorkId, int workFileId) {
		return fileMapper.uploadSubmitWorkFile(submitWorkId, workFileId);
	}

	@Override
	public int delExpWorkFile(int workFileId) {
		WorkFile workFile=fileMapper.getWorkFileById(workFileId);
		FileHelper.delFile(workFile.getPath(),FileHelper.exploreWorkFilePath);
		return fileMapper.delWorkFile(workFileId);
	}

	@Override
	public int delSubWorkFile(int workFileId) {
		WorkFile workFile=fileMapper.getWorkFileById(workFileId);
		FileHelper.delFile(workFile.getPath(),FileHelper.submitWorkFilePath);
		return fileMapper.delWorkFile(workFileId);
	}

	@Override
	public int downloadExpFile(String saveName, HttpServletResponse response) {
		WorkFile workFile=fileMapper.getWorkFileByPath(saveName);
		FileHelper.downLoadFile(response,saveName,FileHelper.exploreWorkFilePath,workFile.getName());
		return 1;
	}

	@Override
	public int downloadSubFile(String saveName, HttpServletResponse response) {
		WorkFile workFile=fileMapper.getWorkFileByPath(saveName);
		FileHelper.downLoadFile(response,saveName,FileHelper.submitWorkFilePath,workFile.getName());
		return 1;
	}

}
