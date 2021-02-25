package com.ts.coursework.dto;

import com.ts.coursework.entity.ExploreWorkFile;
import com.ts.coursework.entity.WorkFile;

public class ExploreWorkFileDto extends ExploreWorkFile{
	
	WorkFile workFile;
	
	public ExploreWorkFileDto(ExploreWorkFile exploreWorkFile) {
		this.setExploreWorkId(exploreWorkFile.getExploreWorkId());
		this.setId(exploreWorkFile.getId());
		this.setWorkFileId(exploreWorkFile.getWorkFileId());
	}

	public WorkFile getWorkFile() {
		return workFile;
	}

	public void setWorkFile(WorkFile workFile) {
		this.workFile = workFile;
	}
}
