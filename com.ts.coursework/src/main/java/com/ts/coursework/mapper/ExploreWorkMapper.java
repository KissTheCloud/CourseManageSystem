package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ts.coursework.entity.ExploreWork;

@Mapper
public interface ExploreWorkMapper {
	int addExploreWork(ExploreWork exploreWork);
	int delExploreWork(int id);
	int updateExploreWork(ExploreWork exploreWork);
	List<ExploreWork> getExploreWorksByCourseId(int courseId);
	ExploreWork getExploreWorkById(int exploreWorkId);
}
