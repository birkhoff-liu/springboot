package com.birkhoff.boot.dao;


import com.birkhoff.boot.pojo.DatabaseUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
	
	public DatabaseUser getUser(String userName);
}
