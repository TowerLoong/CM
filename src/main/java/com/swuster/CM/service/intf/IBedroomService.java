package com.swuster.CM.service.intf;

public interface IBedroomService {
	/**
	 * 通过用户id查询用户对应寝室的名字
	 * @return
	 */
	public String findBedNameByUserId(Integer bedId);
}
