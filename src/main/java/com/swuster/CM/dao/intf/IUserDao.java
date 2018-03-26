package com.swuster.CM.dao.intf;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swuster.CM.dao.model.User;

@Repository
public interface IUserDao extends JpaRepository<User,Integer>{

	// 根据用户id查询用户寝室id（下面这种是原生sql查询的方法）
	@Query(value = "select u.bed_id from t_user u where u.user_id=?1", nativeQuery = true)
	public Integer findBedIdByUserId(Integer userId);
	
	//根据用户寝室id查询用户id
	@Query(value = "select u.user_id from t_user u where u.bed_id=?1", nativeQuery = true)
	public List<Integer> findUserIdByBedId(Integer bedId);
	
}
