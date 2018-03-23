package com.swuster.CM.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuster.CM.dao.intf.IBedroomDao;
import com.swuster.CM.service.intf.IBedroomService;

@Service
public class BedroomServiceImpl implements IBedroomService{

	@Autowired
	private IBedroomDao bedroomDao;
	
}
