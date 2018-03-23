package com.swuster.CM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuster.CM.dao.intf.IMemorandumDao;
import com.swuster.CM.service.intf.IMemorandumService;

@Service
public class MemorandumServiceImpl implements IMemorandumService{

	@Autowired
	private IMemorandumDao memorandumDao;
	
}
