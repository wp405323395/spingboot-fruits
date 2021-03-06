package com.wangpan.s.user.mapper;

import com.wangpan.s.user.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author max_wang
 * @since 2019-05-13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	int insertUser(User user);
	User findUserById(int id);
	User findUserByName(String name);
}
