package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ts.coursework.entity.ExploreWorkFile;
import com.ts.coursework.entity.SubmitWorkFile;
import com.ts.coursework.entity.WorkFile;

@Mapper
public interface FileMapper {
	/*获取ExploreWork对应的文件*/
	List<? extends ExploreWorkFile> getExploreWorkFiles(int exploreWorkId);
	/*获取WorkFile*/
	WorkFile getWorkFileById(int workFileId);
	
	/*获取提交的作业*/
	List<? extends SubmitWorkFile> getSubmitWorkFiles(int submitWorkId);
	//不是上传文件，只是修改对应的表
	int uploadExploreWorkFile(@Param("exploreWorkId")int exploreWorkId,@Param("workFileId")int workFileId);
	int uploadSubmitWorkFile(@Param("submitWorkId")int submitWorkId,@Param("workFileId")int workFileId);
	
	int uploadWorkFile(@Param("name")String name,@Param("path")String path);
	
	WorkFile getWorkFileByPath(String path);
	
	int delWorkFile(int workFileId);
}
