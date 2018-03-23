package com.swuster.CM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuster.CM.dao.intf.IUserDao;
import com.swuster.CM.dao.model.User;
import com.swuster.CM.service.intf.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void delUserById(Integer id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}
	
}
