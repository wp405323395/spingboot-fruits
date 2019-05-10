package com.wangpan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangpan.entity.po.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
	List<User> findAll(int userType);
	int insertUser(User user);
	User findUserById(int id);
	List<User> findByCarpoolingId(int carpoolingId);
	User findUserByName(String name);
}
