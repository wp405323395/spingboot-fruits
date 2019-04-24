package com.wangpan.interceptor;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangpan.result.ResultEnum;
import com.wangpan.result.ResultUtil;

@ControllerAdvice
public class GloablExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        if(msg == "401") {
        	return ResultUtil.error(ResultEnum.Auther_ERROR);
        } else {
        	return ResultUtil.error(ResultEnum.BUSINESS_ERROR.getCode(), msg);        	
        }
    }
}
