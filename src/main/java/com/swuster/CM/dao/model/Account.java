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
 * 账单信息实体类
 */
@Entity  
@Table(name = "t_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "account_id")
	private Integer accountId;//主键
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;//记录账单的那个用户的id
	
	@Column(name = "acc_description" , nullable = false , length = 100) 
	private String accDescription;//花费的内容描述
	
	@Column(name = "acc_spend" , nullable = false , length = 10) 
	private Integer accSpend;//花费的金额
	
	@Column(name = "acc_date" , nullable = true , length = 10) 
	private Date accDate;//花费的时间（可以为空）

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", user=" + user + ", accDescription=" + accDescription
				+ ", accSpend=" + accSpend + ", accDate=" + accDate + "]";
	}

	public Account() {
		super();
	}

	public Account(Integer accountId, User user, String accDescription, Integer accSpend, Date accDate) {
		super();
		this.accountId = accountId;
		this.user = user;
		this.accDescription = accDescription;
		this.accSpend = accSpend;
		this.accDate = accDate;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccDescription() {
		return accDescription;
	}

	public void setAccDescription(String accDescription) {
		this.accDescription = accDescription;
	}

	public Integer getAccSpend() {
		return accSpend;
	}

	public void setAccSpend(Integer accSpend) {
		this.accSpend = accSpend;
	}

	public Date getAccDate() {
		return accDate;
	}

	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}
	
}
