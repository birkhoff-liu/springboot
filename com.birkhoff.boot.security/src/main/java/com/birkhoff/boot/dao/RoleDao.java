package com.birkhoff.boot.dao;

import java.util.List;

import com.birkhoff.boot.pojo.DatabaseRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao {
	
	public List<DatabaseRole> findRolesByUserName(String userName);
}
