package com.swuster.CM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swuster.CM.dao.model.User;
import com.swuster.CM.service.intf.IUserService;

@Controller
@SpringBootApplication
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	/**
	 * 镜子的启动页面，
	 * @return
	 */
	@RequestMapping("/start")
	@ResponseBody 
	public String cmStart(){
		return null;
	}
	
	@RequestMapping("/add")
	@ResponseBody 
	public User addUser(User user){

		userService.addUser(user);
		return user;
	}
	
	@RequestMapping("/del")
	@ResponseBody 
	public String delUserById(Integer userId){
	
		userService.delUserById(userId);
		return userId.toString();
	}
	
}
