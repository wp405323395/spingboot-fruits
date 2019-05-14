package com.wangpan.s.user.entity.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserVO implements Serializable {
	private String id;
	private String name;
	private String communityName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String userDesc;
	private int userType;  //0：无车族，1: 有车族
	private String licensePlate;
	private Integer sex;
}
