package com.wangpan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangpan.annotation.UserLoginToken;
import com.wangpan.entity.po.User;
import com.wangpan.mapper.UserMapper;
import com.wangpan.result.ResultEnum;
import com.wangpan.result.ResultUtil;
import com.wangpan.service.AccountService;
import com.wangpan.service.TokenService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private AccountService accountService;
	@Autowired
	private TokenService tokenService;
	// curl -H "Content-Type: application/json" -X POST  --data '{"name":"zhangsan", "password":"123456"}' http://127.0.0.1:8986/fruits/user/login
	@PostMapping("/login")
	public Object login(@RequestBody User user) {
		User userForBase = accountService.findUserByName(user.getName());
		if(userForBase == null) {
			return ResultUtil.error(ResultEnum.BUSINESS_ERROR.getCode(), "登陆失败用户不存在");
		} else {
			if(!userForBase.getPassword().equals(user.getPassword())) {
				return ResultUtil.error(ResultEnum.BUSINESS_ERROR.getCode(), "您输入的账号或者密码不正确！");
			} else {
				String token = tokenService.getToken(user);
				return ResultUtil.success(token);
			}
		}
	}
	//curl -H "token: ${token}" http://localhost:8986/fruits/user/queryAllDriver
	@UserLoginToken
	@RequestMapping("/queryAllDriver")
	public Object queryAllDriver() {
		return ResultUtil.success(accountService.findAll(1));
	}
	
	//curl http://localhost:8986/fruits/user/queryAllPassenger
	@GetMapping("/queryAllPassenger")
	public Object queryAllPassenger() {
		return ResultUtil.success(accountService.findAll(0));
	}
	
	// curl -H "Content-Type: application/json" -H "token:${token} " -X POST  --data '{"name":"zhangmeng", "password":"123456", "communityName":"fff", "userDesc":"www", "userType":0}' http://127.0.0.1:8986/fruits/user/addUser
	@UserLoginToken
	@PostMapping("/addUser")
	public Object insertUser(@RequestBody User user) {
		accountService.insertUser(user);
		return ResultUtil.success();
	}
}
