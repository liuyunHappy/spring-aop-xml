package com.liuyun.aop.service.impl;

import java.util.List;

import com.liuyun.aop.dao.IUserDao;
import com.liuyun.aop.domain.User;
import com.liuyun.aop.service.IUserService;

/**
 *
 * @author liuyun
 * @version
 * @since 2019年8月29日下午7:43:54
 */
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public long count() throws Exception {
		System.out.println("Service的count执行");
		return userDao.count();
	}

	@Override
	public int deleteById(Integer id) throws Exception {
		return userDao.deleteById(id);
	}

	@Override
	public int insert(User record) throws Exception {
		return userDao.insert(record);
	}

	@Override
	public int update(Integer id, User record) throws Exception {
		if (id == null || record == null) {
			throw new RuntimeException("update input params cannot be null...");
		}
		record.setId(id);
		return userDao.update(record);
	}

	@Override
	public List<User> findAll() throws Exception {
		return userDao.findAll();
	}

	@Override
	public User findById(Integer id) throws Exception {
		return userDao.findById(id);
	}
}
