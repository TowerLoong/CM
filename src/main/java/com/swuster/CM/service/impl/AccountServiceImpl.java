package com.swuster.CM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuster.CM.dao.intf.IAccountDao;
import com.swuster.CM.dao.intf.IUserDao;
import com.swuster.CM.dao.model.Account;
import com.swuster.CM.dao.model.User;
import com.swuster.CM.service.intf.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	private IAccountDao accountDao;
	
	@Autowired
	private IUserDao userDao;

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.save(account);
	}

	@Override
	public List<Account> findAccountByUserId(Integer userId) {
		// TODO Auto-generated method stub
		User user = userDao.findOne(userId);
		List<Account> accList =  accountDao.findByUser(user);
		return accList;
	}
	
}
