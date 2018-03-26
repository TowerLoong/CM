package com.swuster.CM.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swuster.CM.dao.model.CourseSchedule;

@Repository
public interface ICourseScheduleDao extends JpaRepository<CourseSchedule, Integer>{

	//根据用户id周数、天数查询当天的全部课程
		//@Query(value = "select cs.cs_id , cs.cs_course1 , cs.cs_course2 , cs.cs_course3 , cs.cs_course4 , cs.cs_course5 ,cs.cs_course6 from t_course_schedule cs where cs.cs_now_week = ?1 and cs.cs_now_day = ?2 and cs.u_id = ?3", nativeQuery = true) 
	@Query(value = "select cs.* from t_course_schedule cs where cs.cs_now_week = ?1 and cs.cs_now_day = ?2 and cs.u_id = ?3", nativeQuery = true) 
		public CourseSchedule findAllCourse( String nowWeek , String nowDay , Integer userId);
	
}
