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
 * 2018.3.23
 * @author Tower
 * 用户信息实体类
 */
@Entity  
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "user_id")
	private Integer userId;//主键
	
	@Column(name = "user_name" , nullable = false , length = 20) 
	private String userName;//用户昵称（少于20个字符）
	
	@Column(name = "user_password" , nullable = false , length = 20) 
	private String userPassword;//用户密码密码（少于20个字符）
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "bed_id")
	private Bedroom bedroom;//外键，多个用户属于一个寝室

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", bedroom="
				+ bedroom + "]";
	}

	public User() {
		super();
	}

	public User(Integer userId, String userName, String userPassword, Bedroom bedroom) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.bedroom = bedroom;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Bedroom getBedroom() {
		return bedroom;
	}

	public void setBedroom(Bedroom bedroom) {
		this.bedroom = bedroom;
	}
	
}
