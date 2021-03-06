package com.swuster.CM.dao.intf;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swuster.CM.dao.model.Account;
import com.swuster.CM.dao.model.User;

@Repository
public interface IAccountDao extends JpaRepository<Account,Integer>{

	//根据用户查询账单
	public List<Account> findByUser(User user);
	
}
