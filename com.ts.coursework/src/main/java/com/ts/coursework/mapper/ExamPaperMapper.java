package com.ts.coursework.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ts.coursework.entity.ExamPaper;

@Mapper
public interface ExamPaperMapper {
	void addExamPaper(ExamPaper examPaper);
	void delExamPaper(int id);
	void updateExamPaper(ExamPaper examPaper);
	ExamPaper getExamPaperById(int id);
	List<ExamPaper> getAllExamPaper();
	List<ExamPaper> getExamPaperBySubjectId(int subjectId);	
}
