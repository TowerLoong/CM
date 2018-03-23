package com.swuster.CM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swuster.CM.dao.model.Account;
import com.swuster.CM.service.intf.IAccountService;

@Controller
@SpringBootApplication
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	@RequestMapping("/add")
	@ResponseBody 
	public Account addAccount(Account account){
		accountService.addAccount(account);
		return account;
	}
	
	@RequestMapping("/findByUserId")
	@ResponseBody 
	public List<Account> findAccountByUserId(Integer userId){
		
		List<Account> accList = accountService.findAccountByUserId(userId);
		return accList;
		
	}
	
}
