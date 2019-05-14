package com.wangpan.s.user.service;

import com.wangpan.s.user.entity.User;

public interface TokenService {
	public String getToken(User user);
}
