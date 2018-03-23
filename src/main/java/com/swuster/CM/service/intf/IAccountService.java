package com.swuster.CM.service.intf;

import java.util.List;

import com.swuster.CM.dao.model.Account;

public interface IAccountService {

	public void addAccount(Account account);
	
	public List<Account> findAccountByUserId(Integer userId);
	
}
