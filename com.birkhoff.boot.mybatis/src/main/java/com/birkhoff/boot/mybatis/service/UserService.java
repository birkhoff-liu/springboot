package com.birkhoff.boot.mybatis.service;

import com.birkhoff.boot.mybatis.domain.UserInfo;

import java.util.List;


public interface UserService {

	/**
	 * findAll
	 * @return
	 */
	List<UserInfo> findAll();
	
	UserInfo findOne(int id);
}
