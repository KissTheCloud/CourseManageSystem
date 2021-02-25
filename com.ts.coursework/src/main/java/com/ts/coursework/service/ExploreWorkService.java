package com.ts.coursework.service;

import java.util.List;

import com.ts.coursework.dto.ExploreWorkDto;
import com.ts.coursework.entity.ExploreWork;

public interface ExploreWorkService {
	List<ExploreWorkDto> getExploreWorksByCourseId(int courseId);
	int addExploreWork(ExploreWork exploreWork);
	int updateExploreWork(ExploreWork exploreWork);
	int delExploreWork( int exploreWorkId);
	ExploreWork getExploreWorkById(int exploreWorkId);
}
