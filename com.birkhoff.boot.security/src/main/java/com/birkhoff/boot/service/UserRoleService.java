package com.birkhoff.boot.service;

import com.birkhoff.boot.pojo.DatabaseRole;
import com.birkhoff.boot.pojo.DatabaseUser;

import java.util.List;


public interface UserRoleService {

	public DatabaseUser getUserByName(String userName);

	public List<DatabaseRole> findRolesByUserName(String userName);
}
