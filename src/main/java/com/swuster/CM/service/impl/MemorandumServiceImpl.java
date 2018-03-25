package com.swuster.CM.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuster.CM.dao.intf.IMemorandumDao;
import com.swuster.CM.dao.intf.IUserDao;
import com.swuster.CM.dao.model.Memorandum;
import com.swuster.CM.dao.model.User;
import com.swuster.CM.service.intf.IMemorandumService;

@Service
public class MemorandumServiceImpl implements IMemorandumService{

	@Autowired
	private IMemorandumDao memorandumDao;
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<Memorandum> findMemByUserId(Integer userId) {
		// TODO Auto-generated method stub
		User user = userDao.findOne(userId);

		List<Memorandum> memList = memorandumDao.findByUser(user);
		System.out.println(memList);
		 memList = null;
		
		return memList;
	}

	/**
	 * 查找全部备忘录
	 */
	@Override
	public List<Memorandum> findAll() {
		// TODO Auto-generated method stub
		//List<Memorandum> memAll = memorandumDao.findAll();
		//不能直接findAll，会出现死循环
		List<Integer> allId = memorandumDao.findAllMemId();
		List<Integer> allUser = memorandumDao.findAllUserId();
		List<String> allMem = memorandumDao.findAllMemDescription();
		List<Date> allCreateDate = memorandumDao.findAllMemCreateDate();
		List<Date> allAlertDate = memorandumDao.findAllMemAlertDate();
		
		//把查询出来的全部的数据拼接成需要返回给前端的数据
		List<Memorandum> memAll = new ArrayList<Memorandum>();
		for(int i = 0; i < allId.size();i++){
			Memorandum memTemp = new Memorandum();
			memTemp.setMemId(allId.get(i));
			User userTemp = new User();
			userTemp.setUserId(allId.get(i));
			memTemp.setUser(userTemp);
			memTemp.setMemDescription(allMem.get(i));
			memTemp.setMemCreateDate(allCreateDate.get(i));
			memTemp.setMemAlertDate(allAlertDate.get(i));
			
			memAll.add(memTemp);
		}
		
		return memAll;
	}

	/**
	 * 查找今天的备忘录信息
	 */
	@Override
	public List<String> findTodayMem(Integer userId) {
		// TODO Auto-generated method stub
		List<String> todayMem = new ArrayList<String>();
	    try {
	    	//设置日期格式
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    String stringDate = df.format(new java.util.Date());
			java.util.Date utilDate = df.parse(stringDate);
			//把util.Date转化成成sql.Date
			 java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
			 
			 todayMem = memorandumDao.findByMemAlertDate(sqlDate,userId);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return todayMem;
	}

	/**
	 * 添加一条备忘录信息
	 */
	@Override
	public List<Memorandum> addMem(Memorandum mem) {
		// TODO Auto-generated method stub
		
		memorandumDao.save(mem);
		return null;
	}
	
}
