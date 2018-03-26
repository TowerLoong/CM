package com.swuster.CM.service.impl;

import java.util.ArrayList;
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

	/**
	 * 根据用户id查询该用户的账单情况
	 */
	@Override
	public List<Account> findAccountByUserId(Integer userId) {
		// TODO Auto-generated method stub
		User user = userDao.findOne(userId);
		List<Account> accList =  accountDao.findByUser(user);
		return accList;
	}

	/**
	 * 根据用户id查询该用户所属寝室的账单总额
	 * @param userId
	 * @return
	 */
	@Override
	public Integer findBedAccountByUserId(Integer userId) {
		// TODO Auto-generated method stub
		
		//根据用户id查询到该用户对应的寝室id
		Integer bedId = userDao.findBedIdByUserId(userId);
		//根据寝室id查询到该寝室全部成员的id
		List<Integer> usersId = new ArrayList<Integer>();
		usersId = userDao.findUserIdByBedId(bedId);
		
		//根据查询出来的寝室成员id，以此查询出他们各自的账单金额，然后相加
		Integer allAccount = 0;
		for(int i = 0;i < usersId.size();i++){
			
			List<Account> tempAccount = new ArrayList<Account>();
			tempAccount =  findAccountByUserId(usersId.get(i));
			for(int j = 0;j < tempAccount.size();j++){
				allAccount = allAccount + tempAccount.get(j).getAccSpend();
			}
	
		}
		return allAccount;
	}
	
}
