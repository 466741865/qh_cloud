package com.qh.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qh.cloud.dao.UsersDao;
import com.qh.cloud.model.po.Users;
import com.qh.cloud.service.UsersService;

/**
 * 
 * @author QingHang
 * @date 2017年1月11日
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	
	@Override
	public List<Users> findList() {
		return usersDao.findList();
	}

	@Override
	public Users findById(int id) {
		return usersDao.findById(id);
	}

	@Override
	public boolean save(Users users) {
		return (usersDao.save(users) == 1 ? true : false);
	}

	@Override
	public boolean update(Users users) {
		return (usersDao.update(users) == 1 ? true : false);
	}

	@Override
	public void delete(int id) {
		usersDao.deleteById(id);
	}

}
