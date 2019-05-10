package com.wangpan.entity.po;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class User implements Serializable{

	private String id;
	private String name;
	private String password;
	private String communityName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String userDesc;
	private int userType;  //0：无车族，1: 有车族
	private String licensePlate;
	private int sex;
}
