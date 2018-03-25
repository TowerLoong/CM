package com.swuster.CM.dao.intf;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swuster.CM.dao.model.Memorandum;
import com.swuster.CM.dao.model.User;

@Repository
public interface IMemorandumDao extends JpaRepository<Memorandum,Integer>{

	public List<Memorandum> findByUser(User user);
	
	//查询全部memId
	@Query("select m.memId from Memorandum m")
	public List<Integer> findAllMemId();
	
	//查询全部的user
	@Query("select m.user.userId from Memorandum m")
	public List<Integer> findAllUserId();
	
	//查询全部的memDescription
	@Query("select m.memDescription from Memorandum m")
	public List<String> findAllMemDescription();
	
	//查询全部的memCreateDate
	@Query("select m.memCreateDate from Memorandum m")
	public List<Date> findAllMemCreateDate();
	
	//查询全部的memAlertDate
	@Query("select m.memAlertDate from Memorandum m")
	public List<Date> findAllMemAlertDate();
	
	//查询全部的status
	@Query("select m.status from Memorandum m")
	public List<Integer> findAllStatus();
	
	//根据时间查询数据（下面这种是原生sql查询的方法）
	@Query(value = "select m.mem_description from t_mem m where m.mem_alert_date=?1 and m.user_id = ?2", nativeQuery = true)  
	public List<String> findByMemAlertDate( Date date , Integer userId);
	
}
