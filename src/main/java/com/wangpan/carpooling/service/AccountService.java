package com.wangpan.carpooling.service;

import java.util.List;

import com.wangpan.carpooling.entity.po.User;
import com.wangpan.carpooling.entity.vo.UserVO;

public interface AccountService{
	public User findUserByName(String userName);
	public List<UserVO> findAll(int type);
	public int insertUser(User user);
	
}
