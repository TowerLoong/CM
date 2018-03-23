package com.swuster.CM.dao.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 2018.3.23
 * @author Tower
 * 备忘录信息实体类
 */
@Entity  
@Table(name = "t_mem")
public class Memorandum {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "mem_id")
	private Integer memId;//主键
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;//记录备忘录的那个用户的id
	
	@Column(name = "mem_description" , nullable = false , length = 100) 
	private String memDescription;//备忘录的内容
	
	@Column(name = "mem_create_date" , nullable = true , length = 10) 
	private Date memCreateDate;//备忘录的创建时间（可以为空）
	
	@Column(name = "mem_alert_date" , nullable = true , length = 10) 
	private Date memAlertDate;//备忘录的提醒时间（可以为空）
	
	@Column(name = "mem_status" , nullable = true , length = 10) 
	private Integer status;//备忘录的状态（为1表示备忘录可用，为0表示备忘录已经过期）

	@Override
	public String toString() {
		return "Memorandum [memId=" + memId + ", user=" + user + ", memDescription=" + memDescription
				+ ", memCreateDate=" + memCreateDate + ", memAlertDate=" + memAlertDate + ", status=" + status + "]";
	}

	public Memorandum() {
		super();
	}

	public Memorandum(Integer memId, User user, String memDescription, Date memCreateDate, Date memAlertDate,
			Integer status) {
		super();
		this.memId = memId;
		this.user = user;
		this.memDescription = memDescription;
		this.memCreateDate = memCreateDate;
		this.memAlertDate = memAlertDate;
		this.status = status;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMemDescription() {
		return memDescription;
	}

	public void setMemDescription(String memDescription) {
		this.memDescription = memDescription;
	}

	public Date getMemCreateDate() {
		return memCreateDate;
	}

	public void setMemCreateDate(Date memCreateDate) {
		this.memCreateDate = memCreateDate;
	}

	public Date getMemAlertDate() {
		return memAlertDate;
	}

	public void setMemAlertDate(Date memAlertDate) {
		this.memAlertDate = memAlertDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
