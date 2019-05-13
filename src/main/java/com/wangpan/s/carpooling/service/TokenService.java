package com.wangpan.s.carpooling.service;

import com.wangpan.s.user.entity.User;

public interface TokenService {
	public String getToken(User user);
}
