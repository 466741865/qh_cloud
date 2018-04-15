package com.qh.cloud.service;

import java.util.List;

import com.qh.cloud.model.po.Users;

/**
 * 
 * @author QingHang
 * @date 2017年1月11日
 */
public interface UsersService {
	
	List<Users> findList();
	
	Users findById(int id);
	
	boolean save(Users users);
	
	boolean update(Users users);
	
	void delete(int id);
	
	
}
