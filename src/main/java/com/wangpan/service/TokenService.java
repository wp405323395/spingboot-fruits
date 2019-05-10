package com.wangpan.service;

import com.wangpan.entity.po.User;


public interface TokenService {
	public String getToken(User user);
}
