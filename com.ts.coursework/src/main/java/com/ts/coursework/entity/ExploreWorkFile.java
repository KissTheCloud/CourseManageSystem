package com.ts.coursework.entity;

/**
 * 对应每个发布的作业附带的文件，这不是文件的链接，而是作业与文件的映射表
 * @author ts
 *
 */
public class ExploreWorkFile {
	private int id;
	private int exploreWorkId;
	private int workFileId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExploreWorkId() {
		return exploreWorkId;
	}
	public void setExploreWorkId(int exploreWorkId) {
		this.exploreWorkId = exploreWorkId;
	}
	public int getWorkFileId() {
		return workFileId;
	}
	public void setWorkFileId(int workFileId) {
		this.workFileId = workFileId;
	}
	
}
