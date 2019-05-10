package com.wangpan.service;

import java.util.List;

import com.wangpan.entity.po.User;
import com.wangpan.entity.vo.UserVO;

public interface AccountService{
	public User findUserByName(String userName);
	public List<UserVO> findAll(int type);
	public int insertUser(User user);
	
}
