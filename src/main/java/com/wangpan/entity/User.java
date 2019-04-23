package com.wangpan.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private String name;
	private String password;
	private String communityName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private String desc;
	private int userType;  //0：无车族，1: 有车族
	private String id;
	
	public int getUserType() {
		return userType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
