package com.wangpan.mapper;

import java.util.List;

import com.wangpan.entity.po.User;

public interface UserMapper{
	List<User> findAll(int userType);
	int insertUser(User user);
	User findUserById(int id);
	List<User> findByCarpoolingId(String carpoolingId);
	User findUserByName(String name);
}
