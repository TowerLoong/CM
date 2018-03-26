package com.swuster.CM.dao.intf;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swuster.CM.dao.model.Course;

@Repository
public interface ICourseDao extends JpaRepository<Course, Integer>{

	//根据课程id查询课程信息
	public Course findByCoId( Integer coId);
	
}
