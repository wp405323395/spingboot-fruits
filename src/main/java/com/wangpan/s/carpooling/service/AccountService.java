package com.wangpan.s.carpooling.service;

import java.util.List;

import com.wangpan.s.carpooling.entity.po.User;
import com.wangpan.s.carpooling.entity.vo.UserVO;

public interface AccountService{
	public User findUserByName(String userName);
	public List<UserVO> findAll(int type);
	public int insertUser(User user);
	
}
