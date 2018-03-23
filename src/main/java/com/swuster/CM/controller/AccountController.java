package com.swuster.CM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swuster.CM.service.intf.IAccountService;

@Controller
@SpringBootApplication
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
}
