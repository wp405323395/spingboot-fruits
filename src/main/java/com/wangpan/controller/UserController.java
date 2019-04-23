package com.wangpan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangpan.entity.User;
import com.wangpan.mapper.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserMapper userMapper;
	
	//curl http://localhost:8986/fruits/user/queryAllDriver
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
