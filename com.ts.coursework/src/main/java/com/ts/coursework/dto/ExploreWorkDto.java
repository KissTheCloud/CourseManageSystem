package com.ts.coursework.dto;

import com.ts.coursework.entity.ExploreWork;

public class ExploreWorkDto extends ExploreWork {
	//批改的人数
	private int corrected;
	//未批改的人数
	private int uncorrected;
	//未交的人数
	private int unsubmited;
	
//	private List<SubmitWork> submitWorks;
	
	public ExploreWorkDto(ExploreWork exploreWork){
		this.setId(exploreWork.getId());
		this.setName(exploreWork.getName());
		this.setContent(exploreWork.getContent());
		this.setExploreTime(exploreWork.getExploreTime());
		this.setEndTime(exploreWork.getEndTime());
		this.setCourseId(exploreWork.getCourseId());
		this.setFullScore(exploreWork.getFullScore());
		this.setUserId(exploreWork.getUserId());
	}
	
	public int getCorrected() {
		return corrected;
	}
	public void setCorrected(int corrected) {
		this.corrected = corrected;
	}

	public int getUncorrected() {
		return uncorrected;
	}

	public void setUncorrected(int uncorrected) {
		this.uncorrected = uncorrected;
	}

	public int getUnsubmited() {
		return unsubmited;
	}

	public void setUnsubmited(int unsubmited) {
		this.unsubmited = unsubmited;
	}
}
