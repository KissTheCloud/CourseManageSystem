package com.ts.coursework.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.ts.coursework.dto.SubmitWorkDto;

public interface SubmitWorkService {
	/*获取学生对应发布作业的所有提交的作业*/
	SubmitWorkDto getSubmitWork(int exploreWorkId);
	/*获取发布作业的所有提交的作业*/
	List<? extends SubmitWorkDto> getSubmitWorksByExploreWorkId(int exploreWorkId);
	/*exploreWork发布时为所有学生创建submitWork，学生加入课程时也对应每个ExploreWork创建对应的SubmitWork*/
	int addSubmitWork(@Param("exploreWorkId")int exploreWorkId,@Param("userId")Long userId);
}
