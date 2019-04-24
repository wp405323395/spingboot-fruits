package com.wangpan.mapper;

import java.util.List;

import com.wangpan.entity.User;

public interface UserMapper {
	List<User> findAll(int userType);
	void insertUser(User user);
	User findUserById(int id);
	List<User> findByCarpoolingId(String carpoolingId);
	User findUserByName(String name);
}
