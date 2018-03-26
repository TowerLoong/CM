package com.swuster.CM.service.intf;

import java.util.List;

import com.swuster.CM.dao.model.Account;

public interface IAccountService {

	/**
	 * 添加账单信息
	 * @param account
	 */
	public void addAccount(Account account);
	
	/**
	 * 根据用户id查询对应用户的账单记录
	 * @param userId
	 * @return
	 */
	public List<Account> findAccountByUserId(Integer userId);
	
	/**
	 * 根据用户id查询该用户所属寝室的账单总额
	 * @param userId
	 * @return
	 */
	public Integer findBedAccountByUserId(Integer userId);
	
}
