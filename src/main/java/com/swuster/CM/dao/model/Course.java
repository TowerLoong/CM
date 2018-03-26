package com.swuster.CM.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 2018.3.27
 * @author Tower
 * 课程信息表对应的实体类
 */
@Entity  
@Table(name = "t_course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "co_id")
	private Integer coId;//主键
	
	@Column(name = "co_name" , nullable = false , length = 50) 
	private String coName;//课程名字（少于30个字符）
	
	@Column(name = "co_room" , length = 50) 
	private String coRoom;//课程教室（少于30字符）
	
	@Column(name = "co_teacher" , length = 50) 
	private String coTeacher;//任课教师名字（少于30字符）
	
	@Column(name = "co_begin_week" , length = 30) 
	private String coBeginWeek;//课程开始周数（少于20字符）
	
	@Column(name = "co_end_week" , length = 30) 
	private String coEndWeek;//课程结束周数（少于20字符）
	
	public Course() {
		super();
	}

	public Course(Integer coId, String coName, String coRoom, String coTeacher, String coBeginWeek, String coEndWeek) {
		super();
		this.coId = coId;
		this.coName = coName;
		this.coRoom = coRoom;
		this.coTeacher = coTeacher;
		this.coBeginWeek = coBeginWeek;
		this.coEndWeek = coEndWeek;
	}

	@Override
	public String toString() {
		return "Course [coId=" + coId + ", coName=" + coName + ", coRoom=" + coRoom + ", coTeacher=" + coTeacher
				+ ", coBeginWeek=" + coBeginWeek + ", coEndWeek=" + coEndWeek + "]";
	}

	public Integer getCoId() {
		return coId;
	}

	public void setCoId(Integer coId) {
		this.coId = coId;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public String getCoRoom() {
		return coRoom;
	}

	public void setCoRoom(String coRoom) {
		this.coRoom = coRoom;
	}

	public String getCoTeacher() {
		return coTeacher;
	}

	public void setCoTeacher(String coTeacher) {
		this.coTeacher = coTeacher;
	}

	public String getCoBeginWeek() {
		return coBeginWeek;
	}

	public void setCoBeginWeek(String coBeginWeek) {
		this.coBeginWeek = coBeginWeek;
	}

	public String getCoEndWeek() {
		return coEndWeek;
	}

	public void setCoEndWeek(String coEndWeek) {
		this.coEndWeek = coEndWeek;
	}
	
}










