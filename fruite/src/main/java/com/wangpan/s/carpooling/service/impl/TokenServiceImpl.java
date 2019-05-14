package com.wangpan.s.carpooling.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wangpan.s.carpooling.service.TokenService;
import com.wangpan.s.user.entity.User;

@Service
public class TokenServiceImpl implements TokenService {
	public String getToken(User user) {
		Calendar nowTime = Calendar.getInstance();
	    //有10天有效期
	    nowTime.add(Calendar.DATE, 10);
	    Date expiresDate = nowTime.getTime();
		String token="";
        token= JWT.create().withAudience(user.getName())
        		.withIssuer("fruits")
        		.withSubject("用户")
        		.withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
	}
}
