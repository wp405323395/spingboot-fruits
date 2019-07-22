package com.wangpan.s.user.mapper;

import com.wangpan.s.user.entity.User;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author max_wang
 * @since 2019-07-22
 */
public interface UserMapper extends BaseMapper<User> {
	List<User> findAll(int userType);
	int insertUser(User user);
	User findUserById(int id);
	List<User> findByCarpoolingId(int carpoolingId);
	User findUserByName(String name);
}
