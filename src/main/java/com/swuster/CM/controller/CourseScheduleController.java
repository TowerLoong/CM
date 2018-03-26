package com.swuster.CM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swuster.CM.dao.model.Course;
import com.swuster.CM.service.intf.ICourseScheduleService;

@Controller
@SpringBootApplication
@RequestMapping("/courseSchedule")
public class CourseScheduleController {

	@Autowired
	private ICourseScheduleService courseScheduleService;
	
	/**
	 * 根据周数、天数、课程讲数查询那个时间的课程
	 * @param nowWeek
	 * @param nowDay
	 * @param nowTime
	 * @return
	 */
	@RequestMapping("/findCourse")
	@ResponseBody 
	public Course findCourse(String nowWeek , String nowDay , String nowTime ,Integer userId){
		
		Course course = new Course();
		course = courseScheduleService.findACourese(nowWeek, nowDay, nowTime, userId);
		return course;
	}
	
}
