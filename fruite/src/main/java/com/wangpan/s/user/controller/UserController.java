package com.wangpan.s.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.wangpan.annotation.UserLoginToken;
import com.wangpan.result.Result;
import com.wangpan.result.ResultEnum;
import com.wangpan.result.ResultUtil;
import com.wangpan.s.user.entity.User;
import com.wangpan.s.user.service.IUserService;
import com.wangpan.s.user.service.TokenService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author max_wang
 * @since 2019-07-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private TokenService tokenService;
	// curl -H "token: ${token}" http://localhost:8986/fruits/user/queryAllDriver
	@UserLoginToken
	@RequestMapping("/queryAllDriver")
	public Result<Object> queryAllDriver() {
		return ResultUtil.success(userService.findAll(1));
	}

	// curl http://localhost:8986/fruits/user/queryAllPassenger
	@GetMapping("/queryAllPassenger")
	public Result<Object> queryAllPassenger() {
		return ResultUtil.success(userService.findAll(0));
	}

	// curl -H "Content-Type: application/json" -X POST  --data '{"name":"zhangsan", "password":"123456"}' http://127.0.0.1:8986/fruits/user/login
	@PostMapping("/login")
	public Result<Object> login(@RequestBody User user) {
		User userForBase = userService.findUserByName(user.getName());
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
	
	// curl -H "Content-Type: application/json" -H "token:${token} " -X POST  --data '{"name":"zhangmeng", "password":"123456", "communityName":"fff", "userDesc":"www", "userType":0}' http://127.0.0.1:8986/fruits/user/addUser
	@UserLoginToken
	@PostMapping("/addUser")
	public Result<Object> insertUser(@RequestBody User user) {
		userService.insertUser(user);
		return ResultUtil.success();
	}
}
