package com.ts.coursework.util;

import java.util.List;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ts.coursework.entity.Question;
import com.ts.coursework.entity.UserAnswer;

/**
 * @author Administrator
 *
 */
public class ExamHandler {
	private UserAnswer userAnswer;
	private JSONObject jQuestions;
	
	public ExamHandler(UserAnswer userAnswer) {
		this.userAnswer = userAnswer;
		this.jQuestions=new JSONObject();
	}
	
	public void handle() {
		float totleScore =0;
		List<Question> questions=this.userAnswer.getExamPaper().getQuestions();
		for(Question question:questions) {
			JSONObject jQuestion=JSONObject.parseObject(question.getContent().getContent());
			jQuestion.put("id",new Integer(question.getId()));
			jQuestion.put("subjectId",question.getSubjectId());
			jQuestion.put("score",question.getScore());
			jQuestion.put("name",question.getName());
			jQuestion.put("status",question.getStatus());
			jQuestion.put("contentId",question.getContentId());
			this.jQuestions.put(String.valueOf(question.getId()), jQuestion);
		}
		
		JSONArray  ja=JSONArray.parseArray(this.userAnswer.getText().getContent());
		for(Object object:ja) {
			JSONObject answer=(JSONObject)object;
			JSONObject jQuestion=(JSONObject) this.jQuestions.get(answer.get("questionId"));
			float quesitonScore=jQuestion.getFloatValue("score");
			if("单选题".equals(answer.get("type"))) {
				String right=jQuestion.getString("answer");
				String userAnswer=answer.getString("content");
				if(right.equals(userAnswer)) {
					totleScore+=quesitonScore;
				}
			}
			else if("多选题".equals(answer.get("type"))) {
				JSONArray right=jQuestion.getJSONArray("answers");
				JSONArray userAnswer=answer.getJSONArray("content");
				boolean result=true;
				for(int i=0;i<userAnswer.size();i++) {
					if(i>right.size()) {
						result=false;
						break;
					}
					else if(!right.get(i).equals(userAnswer.get(i))){
						result=false;
						break;
					}
				}
				if(result) {
					totleScore+=quesitonScore;
				}
			}

			else if("判断题".equals(answer.get("type"))) {
				String right=jQuestion.getString("answer");
				String userAnswer=answer.getString("content");
				if(right.equals(userAnswer)) {
					totleScore+=quesitonScore;
				}
			}

			else if("填空题".equals(answer.get("type"))) {
				JSONArray right=jQuestion.getJSONArray("answers");
				JSONArray userAnswer=answer.getJSONArray("content");
				boolean result=true;
				for(int i=0;i<userAnswer.size();i++) {
					if(i>right.size()) {
						result=false;
						break;
					}
					else if(!right.get(i).equals(userAnswer.get(i))){
						result=false;
						break;
					}
				}
				if(result) {
					totleScore+=quesitonScore;
				}
			}

			else if("简答题".equals(answer.get("type"))) {
				String right=jQuestion.getString("answer");
				String userAnswer=answer.getString("content");
				if(right.equals(userAnswer)) {
					totleScore+=quesitonScore;
				}
			}
			
		}
		
		
		
		this.userAnswer.setScore(totleScore);
	}

	public UserAnswer getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(UserAnswer userAnswer) {
		this.userAnswer = userAnswer;
	}
}
