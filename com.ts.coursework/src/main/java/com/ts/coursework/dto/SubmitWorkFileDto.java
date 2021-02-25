package com.ts.coursework.dto;

import com.ts.coursework.entity.SubmitWorkFile;
import com.ts.coursework.entity.WorkFile;

/**这个类没用
 * @author TS
 *
 */
public class SubmitWorkFileDto extends SubmitWorkFile{

	WorkFile workFile;
	
	public SubmitWorkFileDto(SubmitWorkFile submitWorkFile) {
		this.setSubmitWorkId(submitWorkFile.getSubmitWorkId());
		this.setId(submitWorkFile.getId());
		this.setWorkFileId(submitWorkFile.getWorkFileId());
	}

	public WorkFile getWorkFile() {
		return workFile;
	}

	public void setWorkFile(WorkFile workFile) {
		this.workFile = workFile;
	}
}
