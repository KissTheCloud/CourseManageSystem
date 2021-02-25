package com.ts.coursework.service;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.ts.coursework.dto.ExploreWorkFileDto;
import com.ts.coursework.dto.SubmitWorkFileDto;

public interface FileService {
	List<ExploreWorkFileDto> getExploreWorkFiles(int exploreWorkId);
	List<SubmitWorkFileDto> getSubmitWorkFiles(int submitWorkId);
	/*上传文件数据，会修改数据库表work_file*/
	List<Integer> uploadSubWorkFile(MultipartHttpServletRequest request);
	/*上传文件数据，会修改数据库表work_file*/
	List<Integer> uploadExpWorkFile(MultipartHttpServletRequest request);
	/*修改文件数据库，生成作业与文件的映射表*/
	int uploadExploreWorkFile(int exploreWorkId,int workFileId);
	/*修改文件数据库，生成作业与文件的映射表*/
	int uploadSubmitWorkFile(int submitWorkId,int workFileId);
	/*删除文件发布*/
	int delExpWorkFile(int workFileId);
	/*删除上传的文件*/
	int delSubWorkFile(int workFileId);
	/*下载发布的文件*/
	int downloadExpFile(String saveName,HttpServletResponse response);
	/*下载学生上传的文件*/
	int downloadSubFile(String saveName,HttpServletResponse response);
}
