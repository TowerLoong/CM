package com.swuster.CM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuster.CM.dao.intf.IBedroomDao;
import com.swuster.CM.dao.intf.IUserDao;
import com.swuster.CM.service.intf.IBedroomService;

@Service
public class BedroomServiceImpl implements IBedroomService{

	@Autowired
	private IBedroomDao bedroomDao;
	
	@Autowired
	private IUserDao userDao;
	
	/**
	 * 通过用户id查询用户对应寝室的名字
	 * @return
	 */
	@Override
	public String findBedNameByUserId(Integer userId) {
		// TODO Auto-generated method stub
		
		//先查询出寝室id，再根据寝室id查询出寝室名字
		Integer bedId = userDao.findBedIdByUserId(userId);
		String bedName = bedroomDao.findNameByBedId(bedId);
		return bedName;
	}
	
}
