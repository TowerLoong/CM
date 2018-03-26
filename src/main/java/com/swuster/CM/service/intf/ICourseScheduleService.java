package com.swuster.CM.service.intf;

import com.swuster.CM.dao.model.Course;
import com.swuster.CM.dao.model.CourseSchedule;

public interface ICourseScheduleService {
	
	/**
	 * 根据用户id，课程讲数查询特定的课程
	 * @return
	 */
	public Course findACourese(String nowWeek, String nowDay, String nowTime , Integer userId);
	
}
