package com.swuster.CM.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swuster.CM.dao.model.Memorandum;
import com.swuster.CM.service.intf.IMemorandumService;

@Controller
@SpringBootApplication
@RequestMapping("/mem")
public class MemorandomController {

	@Autowired
	private IMemorandumService memorandomService;
	
	/**
	 * 通过用户id查找该用户的备忘录信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("/findByUserId")
	@ResponseBody 
	public List<Memorandum> findAccountByUserId(Integer userId){
		
		System.out.println(userId);
		List<Memorandum> memList = memorandomService.findMemByUserId(userId);
		return memList;
		
	}
	
	/**
	 * 查询全部备忘录信息
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody 
	public List<Memorandum> findAll(){
	
		List<Memorandum> memAllList = new ArrayList<Memorandum>();
		memAllList = memorandomService.findAll();
		
		return memAllList;
	}
	
	/**
	 * 根据用户id查询今天的备忘录信息（需要提醒的）
	 * @return
	 */
	@RequestMapping("/findToday")
	@ResponseBody 
	public List<String> findTodayMemById(Integer userId){
		
		List<String> todayMem = new ArrayList<String>();		
		todayMem = memorandomService.findTodayMem(userId);

		return todayMem;
	}
	
	@RequestMapping("/add")
	@ResponseBody 
	public Memorandum addMem(Memorandum mem){
	
		memorandomService.addMem(mem);
		return mem;
	}
	
}
