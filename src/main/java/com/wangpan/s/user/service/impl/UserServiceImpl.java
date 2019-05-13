package com.wangpan.s.user.service.impl;

import com.wangpan.s.user.entity.User;
import com.wangpan.s.user.entity.vo.UserVO;
import com.wangpan.s.user.mapper.UserMapper;
import com.wangpan.s.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author max_wang
 * @since 2019-05-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
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
