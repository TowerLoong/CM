package com.swuster.CM.service.intf;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import com.swuster.CM.dao.model.Memorandum;

public interface IMemorandumService {

	public List<Memorandum> findMemByUserId(Integer userId);
	
	/**
	 * 查找全部备忘录
	 * @return
	 */
	public List<Memorandum> findAll();
	
	/**
	 * 查找今天的备忘录信息
	 * @return
	 */
	public List<String> findTodayMem(Integer userId);
	
	/**
	 * 添加一条备忘录信息
	 * @return
	 */
	public List<Memorandum> addMem(Memorandum mem);
	
}
