package com.ts.coursework.service.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ts.coursework.dto.ExploreWorkDto;
import com.ts.coursework.entity.ExploreWork;
import com.ts.coursework.entity.SubmitWork;
import com.ts.coursework.entity.User;
import com.ts.coursework.mapper.CourseMapper;
import com.ts.coursework.mapper.ExploreWorkMapper;
import com.ts.coursework.mapper.SubmitWorkMapper;
import com.ts.coursework.service.ExploreWorkService;

@Service
public class ExploreWorkServiceImp implements ExploreWorkService {

	@Autowired
	ExploreWorkMapper exploreWorkMapper;
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	SubmitWorkMapper submitWorkMapper;
	
	
	@Override
	public List<ExploreWorkDto> getExploreWorksByCourseId(int courseId) {
		List<ExploreWork> exploreWorks=exploreWorkMapper.getExploreWorksByCourseId(courseId);
		List<ExploreWorkDto> exploreWorkDtos=new ArrayList<ExploreWorkDto>();
		for(ExploreWork exploreWork:exploreWorks) {
			ExploreWorkDto temp=new ExploreWorkDto(exploreWork);
			//设置未批改的人数
			temp.setUncorrected(1);
			//设置批改的人数
			temp.setCorrected(1);
			//设置未提交的人数
			temp.setUnsubmited(1);
			
			exploreWorkDtos.add(temp);
		}
		return exploreWorkDtos;
	}

	@Override
	public int addExploreWork(ExploreWork exploreWork) {
		exploreWork.setExploreTime(new Timestamp(System.currentTimeMillis()));
		exploreWork.setUserId(this.getCurrentUser().getId());
		
		//检查是否是班级老师或管理员
		
		//发布作业
		exploreWorkMapper.addExploreWork(exploreWork);
		//为每个学生创建SubmitWork
		List<User> stus=courseMapper.getStusByCourseId(exploreWork.getCourseId());
		for(User user : stus) {
			SubmitWork submitWork=new SubmitWork();;
			submitWork.setExploreWorkId(exploreWork.getId());
			submitWork.setUserId(user.getId());
			submitWorkMapper.addSubmitWork(submitWork);
		}
		return 1;
	}

	private User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@Override
	public int updateExploreWork(ExploreWork exploreWork) {
		
		//检查用户是否是该课程老师
		
		return exploreWorkMapper.updateExploreWork(exploreWork);
	}

	@Override
	public int delExploreWork(int exploreWorkId) {
		//检查用户是否是该课程老师
		
		return exploreWorkMapper.delExploreWork(exploreWorkId);
	}

	@Override
	public ExploreWork getExploreWorkById(int exploreWorkId) {
		
		return exploreWorkMapper.getExploreWorkById(exploreWorkId);
	}
	
	
}
