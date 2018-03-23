package com.swuster.CM.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swuster.CM.dao.model.Memorandum;

@Repository
public interface IMemorandumDao extends JpaRepository<Memorandum,Integer>{

}
