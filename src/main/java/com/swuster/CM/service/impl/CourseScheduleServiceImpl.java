package com.swuster.CM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuster.CM.dao.intf.ICourseDao;
import com.swuster.CM.dao.intf.ICourseScheduleDao;
import com.swuster.CM.dao.model.Course;
import com.swuster.CM.dao.model.CourseSchedule;
import com.swuster.CM.service.intf.ICourseScheduleService;

@Service
public class CourseScheduleServiceImpl implements ICourseScheduleService{

	@Autowired
	private ICourseScheduleDao courseScheduleDao;
	
	@Autowired
	private ICourseDao courseDao;

	/**
	 * 根据课程讲数查询特定的课程
	 */
	@Override
	public Course findACourese(String nowWeek, String nowDay, String nowTime,Integer userId) {
		// TODO Auto-generated method stub
		CourseSchedule aalCourse = new CourseSchedule();
		//先查询出这一天的全部六节课
		aalCourse = courseScheduleDao.findAllCourse(nowWeek, nowDay,userId);
		
		if(aalCourse == null)
			return null;
		else{
			//根据讲数查询出特定的那节课
			Integer courseId =null;
			Course course = new Course();
			switch(nowTime){
			case "第一讲":
				courseId = aalCourse.getCourse1().getCoId();
				break;
			case "第二讲":
				courseId = aalCourse.getCourse2().getCoId();
				break;
			case "第三讲":
				courseId = aalCourse.getCourse3().getCoId();
				break;
			case "第四讲":
				courseId = aalCourse.getCourse4().getCoId();
				break;
			case "第五讲":
				courseId = aalCourse.getCourse5().getCoId();
				break;
			case "第六讲":
				courseId = aalCourse.getCourse6().getCoId();
				break;
			}
			if(courseId == null){
				return null;
			}else{
				course = courseDao.findByCoId(courseId);
				return course;
			}
		}

	}
	
	

}
