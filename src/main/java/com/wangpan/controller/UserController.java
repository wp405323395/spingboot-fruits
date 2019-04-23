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
		List<User> drivers = new ArrayList<User>();
		User user = new User();
		user.setName("李四");
		user.setUserType(1);
		user.setCommunityName("益达云姗瑚");
		user.setCreateTime(new Date());
		
		User user2 = new User();
		user2.setName("李四");
		user2.setUserType(1);
		user2.setCommunityName("益达云姗瑚");
		user2.setCreateTime(new Date());
		drivers.add(user);
		drivers.add(user2);
		drivers = userMapper.findAll();
		return drivers;
	}
	
	//curl http://localhost:8986/fruits/user/queryAllPassenger
	@GetMapping("/queryAllPassenger")
	public Object queryAllPassenger() {
		List<User> passengers = new ArrayList<User>();
		User user = new User();
		user.setName("李四");
		user.setUserType(1);
		user.setCommunityName("益达云姗瑚");
		user.setCreateTime(new Date());
		
		User user2 = new User();
		user2.setName("李四");
		user2.setUserType(1);
		user2.setCommunityName("益达云姗瑚");
		user2.setCreateTime(new Date());
		passengers.add(user);
		passengers.add(user);
		
		return passengers;
	}
	
	// curl -H "Content-Type: application/json" -X POST  --data '{"name":"zhangsan", "password":"123456"}' http://127.0.0.1:8986/fruits/user/addUser
	@PostMapping("/addUser")
	public Object insertUser(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
}
