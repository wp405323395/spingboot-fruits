package com.wangpan.user.service.impl;

import com.wangpan.user.entity.User;
import com.wangpan.user.mapper.UserMapper;
import com.wangpan.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author max_wang
 * @since 2019-05-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
