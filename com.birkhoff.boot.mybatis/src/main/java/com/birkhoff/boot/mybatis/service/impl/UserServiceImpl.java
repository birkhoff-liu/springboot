package com.birkhoff.boot.mybatis.service.impl;

import java.util.List;

import com.birkhoff.boot.mybatis.domain.UserInfo;
import com.birkhoff.boot.mybatis.mapper.UserMapper;
import com.birkhoff.boot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserInfo> findAll() {
		return userMapper.findAll();
	}

	@Override
	public UserInfo findOne(int id) {
		return userMapper.findOne(id);
	}

}
