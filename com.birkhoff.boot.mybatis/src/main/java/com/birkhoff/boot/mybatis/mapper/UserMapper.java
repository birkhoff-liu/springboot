package com.birkhoff.boot.mybatis.mapper;

import java.util.List;

import com.birkhoff.boot.mybatis.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
	
	/**
	 * findOne
	 * @param id
	 * @return
	 */
	@Select(value="select *from boot_user where id=#{id}")
	UserInfo findOne(int id);

	/**
	 * findAll
	 * @return
	 */
	List<UserInfo> findAll();
}
