package com.swuster.CM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swuster.CM.dao.model.Account;
import com.swuster.CM.dao.model.BedAccountAndName;
import com.swuster.CM.service.intf.IAccountService;
import com.swuster.CM.service.intf.IBedroomService;

@Controller
@SpringBootApplication
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IBedroomService bedroomService;
	
	/**
	 * 添加账单记录
	 * @param account
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody 
	public Account addAccount(Account account){
		accountService.addAccount(account);
		return account;
	}
	
	/**
	 * 根据用户id查询该用户的账单记录
	 * @param userId
	 * @return
	 */
	@RequestMapping("/findByUserId")
	@ResponseBody 
	public List<Account> findAccountByUserId(Integer userId){
		
		List<Account> accList = accountService.findAccountByUserId(userId);
		return accList;
		
	}
	
	/**
	 * 根据用户id查询该用户所属寝室的账单情况
	 * @return
	 */
	@RequestMapping("/findBedAccount")
	@ResponseBody 
	public BedAccountAndName findBedAccountByUserId(Integer userId){
		
		BedAccountAndName bedAccountAndName = new BedAccountAndName();
		//查找寝室总共花费
		Integer bedAccount = accountService.findBedAccountByUserId(userId);
		bedAccountAndName.setBedAccount(bedAccount);
		//查找寝室名字
		String bedName = bedroomService.findBedNameByUserId(userId);
		bedAccountAndName.setBedName(bedName);
	
		return bedAccountAndName;
	}
	
}
