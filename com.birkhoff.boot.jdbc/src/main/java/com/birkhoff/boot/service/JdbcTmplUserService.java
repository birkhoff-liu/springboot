package com.birkhoff.boot.service;

import java.util.List;

import com.birkhoff.boot.pojo.User;

public interface JdbcTmplUserService {
	
	public User getUser(Long id);

	public List<User> findUsers(String userName, String note);

	public int insertUser(User user);

	public int updateUser(User user);

	public int deleteUser(Long id);
	
	public User getUser2(Long id);
	
	public User getUser3(Long id);
}
