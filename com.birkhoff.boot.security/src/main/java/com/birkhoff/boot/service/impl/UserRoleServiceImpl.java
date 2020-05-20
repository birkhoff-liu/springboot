package com.birkhoff.boot.service.impl;

import java.util.List;

import com.birkhoff.boot.dao.RoleDao;
import com.birkhoff.boot.dao.UserDao;
import com.birkhoff.boot.pojo.DatabaseRole;
import com.birkhoff.boot.pojo.DatabaseUser;
import com.birkhoff.boot.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserDao userDao = null;
	@Autowired
	private RoleDao roleDao = null;

	@Override
	@Cacheable(value = "redisCache", key = "'redis_user_'+#userName")
	@Transactional
	public DatabaseUser getUserByName(String userName) {
		return userDao.getUser(userName);
	}

	@Override
	@Cacheable(value = "redisCache", key = "'redis_user_role_'+#userName")
	@Transactional
	public List<DatabaseRole> findRolesByUserName(String userName) {
		return roleDao.findRolesByUserName(userName);
	}

}
