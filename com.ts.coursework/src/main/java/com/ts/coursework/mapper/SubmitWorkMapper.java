package com.ts.coursework.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ts.coursework.entity.SubmitWork;

@Mapper
public interface SubmitWorkMapper {
	/*获取学生对应发布作业的所有提交的作业*/
	SubmitWork getSubmitWork(@Param("exploreWorkId")int exploreWorkId,@Param("userId")Long userId);
	/*获取发布作业的所有提交的作业*/
	List<? extends SubmitWork> getSubmitWorksByExploreWorkId(int exploreWorkId);
	/*exploreWork发布时为所有学生创建submitWork，学生加入课程时也对应每个ExploreWork创建对应的SubmitWork*/
	int addSubmitWork(SubmitWork submitWork);
}
