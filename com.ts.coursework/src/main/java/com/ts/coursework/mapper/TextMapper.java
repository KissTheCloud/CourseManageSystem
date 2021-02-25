package com.ts.coursework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ts.coursework.entity.Text;

@Mapper
public interface TextMapper {
	int addText(Text text);
	void delText(int id);
	void updateText(Text text);
	Text getTextById(int id);
	List<Text> getAllTexts();
}
