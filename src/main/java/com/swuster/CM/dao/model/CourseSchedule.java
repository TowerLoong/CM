package com.swuster.CM.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 2018.3.27
 * @author Tower
 * 课程表所对应的实体类
 * 其中的每一条数据表示”某用户在某一周内的某一天中的6讲课程的情况“
 */
@Entity  
@Table(name = "t_course_schedule")
public class CourseSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "cs_id")
	private Integer csId;//主键
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "u_id")
	private User user;//用户（外键）
	
	@Column(name = "cs_now_week" , length = 30) 
	private String csNowWeek;//课程现在的周数（"第一周"。。。“第十八周”，少于20字符）
	
	@Column(name = "cs_now_day" , length = 30) 
	private String csNowDay;//课程现在的天数（星期一、星期二。。。星期日，少于20字符）
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "cs_course1")
	private Course course1;//这一天的第一讲课程
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "cs_course2")
	private Course course2;//第二讲课程
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "cs_course3")
	private Course course3;//第三讲课程
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "cs_course4")
	private Course course4;//第四讲课程
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "cs_course5")
	private Course course5;//第五讲课程
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "cs_course6")
	private Course course6;//第六讲课程
	
	public CourseSchedule() {
		super();
	}

	public CourseSchedule(Integer csId, User user, String csNowWeek, String csNowDay, Course course1, Course course2,
			Course course3, Course course4, Course course5, Course course6) {
		super();
		this.csId = csId;
		this.user = user;
		this.csNowWeek = csNowWeek;
		this.csNowDay = csNowDay;
		this.course1 = course1;
		this.course2 = course2;
		this.course3 = course3;
		this.course4 = course4;
		this.course5 = course5;
		this.course6 = course6;
	}

	@Override
	public String toString() {
		return "CourseSchedule [csId=" + csId + ", user=" + user + ", csNowWeek=" + csNowWeek + ", csNowDay=" + csNowDay
				+ ", course1=" + course1 + ", course2=" + course2 + ", course3=" + course3 + ", course4=" + course4
				+ ", course5=" + course5 + ", course6=" + course6 + "]";
	}

	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCsNowWeek() {
		return csNowWeek;
	}

	public void setCsNowWeek(String csNowWeek) {
		this.csNowWeek = csNowWeek;
	}

	public String getCsNowDay() {
		return csNowDay;
	}

	public void setCsNowDay(String csNowDay) {
		this.csNowDay = csNowDay;
	}

	public Course getCourse1() {
		return course1;
	}

	public void setCourse1(Course course1) {
		this.course1 = course1;
	}

	public Course getCourse2() {
		return course2;
	}

	public void setCourse2(Course course2) {
		this.course2 = course2;
	}

	public Course getCourse3() {
		return course3;
	}

	public void setCourse3(Course course3) {
		this.course3 = course3;
	}

	public Course getCourse4() {
		return course4;
	}

	public void setCourse4(Course course4) {
		this.course4 = course4;
	}

	public Course getCourse5() {
		return course5;
	}

	public void setCourse5(Course course5) {
		this.course5 = course5;
	}

	public Course getCourse6() {
		return course6;
	}

	public void setCourse6(Course course6) {
		this.course6 = course6;
	}
	
}
