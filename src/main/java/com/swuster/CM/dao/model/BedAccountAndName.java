package com.swuster.CM.dao.model;

/**
 * 用来显示寝室名字和对应账单情况的实体类
 * @author Tower
 *
 */
public class BedAccountAndName {

	private String bedName;
	
	private Integer bedAccount;

	@Override
	public String toString() {
		return "BedAccountAndName [bedName=" + bedName + ", bedAccount=" + bedAccount + "]";
	}

	public BedAccountAndName() {
		super();
	}

	public BedAccountAndName(String bedName, Integer bedAccount) {
		super();
		this.bedName = bedName;
		this.bedAccount = bedAccount;
	}

	public String getBedName() {
		return bedName;
	}

	public void setBedName(String bedName) {
		this.bedName = bedName;
	}

	public Integer getBedAccount() {
		return bedAccount;
	}

	public void setBedAccount(Integer bedAccount) {
		this.bedAccount = bedAccount;
	}
	
}
