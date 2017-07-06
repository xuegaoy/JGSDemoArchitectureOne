package com.sishuok.architecture1.customermgr.dao;


import java.util.List;

import com.sishuok.architecture1.customermgr.vo.CustomerModel;

public interface CustomerDAO {
	
	/*
	 * 增删改查
	 */
	public void create(CustomerModel cm);
	
	public void update(CustomerModel cm);
	
	public void delete(Integer uuid);
	
	public CustomerModel getByUuid(int uuid);
	
	public List<CustomerModel> getByCondition(CustomerModel cqm);
	
}
