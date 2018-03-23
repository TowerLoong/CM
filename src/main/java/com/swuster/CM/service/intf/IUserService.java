package com.swuster.CM.service.intf;

import com.swuster.CM.dao.model.User;

public interface IUserService {

	public void addUser(User user);
	
	public void delUserById(Integer id);
	
}
