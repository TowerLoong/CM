package com.swuster.CM.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swuster.CM.dao.model.Bedroom;

@Repository
public interface IBedroomDao extends JpaRepository<Bedroom, Integer> {

	//通过寝室id查询寝室名字
	@Query(value = "select b.bed_name from t_bedroom b where b.bed_id=?", nativeQuery = true)  
	public String findNameByBedId(Integer bedId);

}
