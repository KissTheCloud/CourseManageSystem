package com.ts.coursework.util;

import com.alibaba.fastjson.JSONArray;

public class JsonTest {
	String jsonStr="[{\"questionId\":19,\"type\":\"填空题\",\"content\":[\"花木兰\"]},{\"questionId\":20,\"type\":\"简答题\",\"content\":\"垃圾游戏\"},{\"questionId\":21,\"type\":\"判断题\",\"content\":\"对\"},{\"questionId\":22,\"type\":\"多选题\",\"content\":[\"李白\",\"花木兰\"]},{\"questionId\":23,\"type\":\"简答题\",\"content\":\"垃圾游戏\"},{\"questionId\":24,\"type\":\"简答题\",\"content\":\"垃圾游戏\"},{\"questionId\":25,\"type\":\"单选题\",\"content\":\"鲁班\"}]";
	
	@SuppressWarnings("unused")
	public JsonTest() {
		JSONArray  jo=JSONArray.parseArray(jsonStr);
		
		
		
	}
	
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	 JsonTest jt=	new JsonTest();
		//System.out.println(jt.jsonStr);
	}
}
