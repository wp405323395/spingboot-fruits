package com.wangpan.s.carpooling.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangpan.s.carpooling.entity.po.User;
import com.wangpan.s.carpooling.entity.vo.UserVO;
import com.wangpan.s.carpooling.mapper.UserMapper;
import com.wangpan.s.carpooling.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
    private UserMapper userMapper;
	@Override
	public User findUserByName(String userName) {
		User userForBase = userMapper.findUserByName(userName);
		return userForBase;
	}
	@Override
	public List<UserVO> findAll(int type) {
		List<User> userList = (List<User>) userMapper.findAll(type);
		List<UserVO> userVoList = new ArrayList<UserVO>();
		for(User user: userList) {
			UserVO userVO = new UserVO();
			BeanUtils.copyProperties(user, userVO);
			userVoList.add(userVO);
		}
		return userVoList;
	}
	@Override
	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}
	
}
