package com.ts.coursework.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.coursework.entity.ExamPaper;
import com.ts.coursework.entity.Question;
import com.ts.coursework.entity.Text;
import com.ts.coursework.entity.UserAnswer;
import com.ts.coursework.mapper.ExamMapper;
import com.ts.coursework.mapper.ExamPaperMapper;
import com.ts.coursework.mapper.QuestionMapper;
import com.ts.coursework.mapper.SubjectMapper;
import com.ts.coursework.mapper.TextMapper;
import com.ts.coursework.mapper.UserAnswerMapper;
import com.ts.coursework.mapper.UserMapper;
import com.ts.coursework.util.ExamHandler;

@Service
public class UserAnswerService {
	@Autowired
	UserAnswerMapper userAnswerMapper;
	@Autowired
	TextMapper textMapper;
	
	@Autowired
	UserService userService;

	@Autowired
	ExamMapper examMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	ExamPaperMapper examPaperMapper;
	
	@Autowired
	SubjectMapper subjectMapper;
	
	@Autowired
	QuestionMapper questionMapper;
	
	public void add(UserAnswer userAnswer) {
		Text text=new Text();
		textMapper.addText(text);
		userAnswer.setTextId(text.getId());
		userAnswer.setStatus(0);
		userAnswer.setUserId(userService.getCurrentUser().getId());
		userAnswerMapper.add(userAnswer);
	}

	
	public void del(int id) {
		//要删除text
		UserAnswer ua=userAnswerMapper.get(id);
		textMapper.delText(ua.getTextId());
		userAnswerMapper.del(id);
	}
	
	public void delByUserIdAndExamId(long userId,int examId) {
		//删除文本，删除userAnswer
		UserAnswer userAnswer=userAnswerMapper.getByUserIdAndExamId(userId, examId);
		textMapper.delText(userAnswer.getTextId());
		userAnswerMapper.delByUserIdAndExamId(userId,examId);
	}
	

	public void update(UserAnswer userAnswer) {
		textMapper.updateText(userAnswer.getText());
		
		//提交试卷后，在这里批改试卷
		ExamHandler examHandler=new ExamHandler(userAnswer);
		examHandler.handle();

		userAnswerMapper.update(userAnswer);
	}

	public UserAnswer get(int id) {
		UserAnswer ua=userAnswerMapper.get(id);
		ua.setExam(examMapper.get(ua.getExamId()));
		ua.setText(textMapper.getTextById(ua.getTextId()));
		ua.setUser(userMapper.getUserById(ua.getUserId()));
		ExamPaper ep=examPaperMapper.getExamPaperById(ua.getExamPaperId());
		List<Question> questions=questionMapper.getQuestionsByExamPaperId(ua.getExamPaperId());
		for(Question question:questions) {
			question.setContent(textMapper.getTextById(question.getContentId()));
		}
		ep.setQuestions(questions);
		ua.setExamPaper(ep);
		ua.setSubject(subjectMapper.getSubjectById(ua.getSubjectId()));
		return ua;
	}
	
	public List<UserAnswer> getByUserId(long userId){
		List<UserAnswer> uas=userAnswerMapper.getByUserId(userId);
		for(UserAnswer ua:uas) {
			ua.setExam(examMapper.get(ua.getExamId()));
			ua.setText(textMapper.getTextById(ua.getTextId()));
			ua.setUser(userMapper.getUserById(ua.getUserId()));
		}
		return uas;
	}
	
	
	public List<UserAnswer> getByUserIdAndExamPaperId(long userId,int examPaperId){
		List<UserAnswer> uas=userAnswerMapper.getByUserIdAndExamPaperId(userId,examPaperId);
		for(UserAnswer ua:uas) {
			ua.setExam(examMapper.get(ua.getExamId()));
			ua.setText(textMapper.getTextById(ua.getTextId()));
			ua.setUser(userMapper.getUserById(ua.getUserId()));
		}
		return uas;
	}
	
	public UserAnswer getByUserIdAndExamId(long userId,int examId) {
		UserAnswer ua=userAnswerMapper.getByUserIdAndExamId(userId,examId);
		ua.setExam(examMapper.get(ua.getExamId()));
		ua.setText(textMapper.getTextById(ua.getTextId()));
		ua.setUser(userMapper.getUserById(ua.getUserId()));
		return ua;
	}
	
	public List<UserAnswer> getByExamId(int examId) {
		List<UserAnswer> uas=userAnswerMapper.getByExamId(examId);
		for(UserAnswer ua:uas) {
			ua.setExam(examMapper.get(ua.getExamId()));
			ua.setText(textMapper.getTextById(ua.getTextId()));
			ua.setUser(userMapper.getUserById(ua.getUserId()));
		}
		return uas;
	}
}
