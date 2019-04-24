package com.wangpan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangpan.annotation.PassToken;
import com.wangpan.annotation.UserLoginToken;
import com.wangpan.entity.User;
import com.wangpan.mapper.UserMapper;
import com.wangpan.service.TokenService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserMapper userMapper;
	@Autowired
	private TokenService tokenService;
	// curl -H "Content-Type: application/json" -X POST  --data '{"name":"zhangsan", "password":"123456"}' http://127.0.0.1:8986/fruits/user/login
	@PostMapping("/login")
	public Object login(@RequestBody User user) {
		User userForBase = userMapper.findUserByName(user.getName());
		if(userForBase == null) {
			return "登陆失败用户不存在";
		} else {
			if(!userForBase.getPassword().equals(user.getPassword())) {
				return "您输入的账号或者密码不正确！";
			} else {
				String token = tokenService.getToken(user);
				return token;
			}
		}
	}
	
	//curl -H "token: 9666eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ6aGFuZ3NhbiJ9.2BQvQP4Suhk1uO-aAdhap4hM1KoyuZosFVTJZbpoH70" http://localhost:8986/fruits/user/queryAllDriver
	@UserLoginToken
	@RequestMapping("/queryAllDriver")
	public Object queryAllDriver() {
		return userMapper.findAll(1);
	}
	
	//curl http://localhost:8986/fruits/user/queryAllPassenger
	@GetMapping("/queryAllPassenger")
	public Object queryAllPassenger() {
		return userMapper.findAll(0);
	}
	
	// curl -H "Content-Type: application/json" -X POST  --data '{"name":"zhangmeng", "password":"123456", "communityName":"fff", "userDesc":"www", "userType":0}' http://127.0.0.1:8986/fruits/user/addUser
	@PostMapping("/addUser")
	public Object insertUser(@RequestBody User user) {
		userMapper.insertUser(user);
		return user;
	}
}
