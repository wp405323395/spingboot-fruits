package com.wangpan.carpooling.service;

import com.wangpan.carpooling.entity.po.User;

public interface TokenService {
	public String getToken(User user);
}
