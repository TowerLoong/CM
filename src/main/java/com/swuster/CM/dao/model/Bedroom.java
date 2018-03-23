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
 * 寝室信息实体类
 */
@Entity  
@Table(name = "t_bedroom")
public class Bedroom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "bed_id")
	private Integer bedId;//主键
	
	@Column(name = "bed_name" , nullable = false , length = 30) 
	private String bedName;//寝室名称（少于30个字符）
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "headuser_id")
	private User headUser;//室长id，一个寝室只有一个室长

	@Override
	public String toString() {
		return "Bedroom [bedId=" + bedId + ", bedName=" + bedName + ", headUser=" + headUser + "]";
	}

	public Bedroom() {
		super();
	}

	public Bedroom(Integer bedId, String bedName, User headUser) {
		super();
		this.bedId = bedId;
		this.bedName = bedName;
		this.headUser = headUser;
	}

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	public String getBedName() {
		return bedName;
	}

	public void setBedName(String bedName) {
		this.bedName = bedName;
	}

	public User getHeadUser() {
		return headUser;
	}

	public void setHeadUser(User headUser) {
		this.headUser = headUser;
	}
	
}
