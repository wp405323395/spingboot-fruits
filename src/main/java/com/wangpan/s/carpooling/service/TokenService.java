package com.wangpan.s.carpooling.service;

import com.wangpan.s.carpooling.entity.po.User;

public interface TokenService {
	public String getToken(User user);
}
