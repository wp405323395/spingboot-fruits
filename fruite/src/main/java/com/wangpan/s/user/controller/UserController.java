package com.wangpan.s.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.wangpan.annotation.UserLoginToken;
import com.wangpan.result.Result;
import com.wangpan.result.ResultUtil;
import com.wangpan.s.user.service.IUserService;

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
}
