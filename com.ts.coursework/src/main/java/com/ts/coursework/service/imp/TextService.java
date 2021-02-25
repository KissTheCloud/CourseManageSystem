package com.ts.coursework.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.coursework.entity.Text;
import com.ts.coursework.mapper.TextMapper;

@Service
public class TextService {
	@Autowired
	TextMapper textMapper;
	
	public int addText(Text text) {
		return textMapper.addText(text);
	}
	public void delText(int id) {
		textMapper.delText(id);
	}
	public 	void updateText(Text text) {
		textMapper.updateText(text);
	}
	public Text getTextById(int id) {
		return textMapper.getTextById(id);
	}
	public List<Text> getAllTexts() {
		return textMapper.getAllTexts();
	}
}
