package com.swuster.CM.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swuster.CM.dao.model.User;

@Repository
public interface IUserDao extends JpaRepository<User,Integer>{

}
