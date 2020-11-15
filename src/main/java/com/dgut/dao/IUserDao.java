package com.dgut.dao;

import org.apache.ibatis.annotations.Select;

import com.dgut.domain.User;

public interface IUserDao {
	
	@Select("select * from user where username = #{username} and password = #{password}")
	public User findByNameAndPassword(User user);

}
