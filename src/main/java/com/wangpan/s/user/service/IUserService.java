package com.wangpan.s.user.service;

import com.wangpan.s.user.entity.User;
import com.wangpan.s.user.entity.vo.UserVO;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author max_wang
 * @since 2019-05-13
 */
public interface IUserService extends IService<User> {
	public User findUserByName(String userName);
	public List<UserVO> findAll(int type);
	public int insertUser(User user);
}
