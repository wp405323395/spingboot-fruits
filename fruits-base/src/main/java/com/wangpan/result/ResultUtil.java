package com.wangpan.result;

public class ResultUtil {
	 
    /**成功且带数据**/
    public static Result<Object> success(Object object){
        Result<Object> result = new Result<Object>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static Result<Object> success(){
 
        return success(null);
    }
    /**失败**/
    public static Result<Object> error(Integer code,String msg){
    	Result<Object> result = new Result<Object>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static Result<Object> error(ResultEnum resultEnum){
    	Result<Object> result = new Result<Object>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

}