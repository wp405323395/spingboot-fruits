package com.wangpan.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Carpooling {
	private String id;
	private String carPoolingName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private int createBy;
	private int startSiteId;
	private int endSiteId;
	
	public Carpooling() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarPoolingName() {
		return carPoolingName;
	}
	public void setCarPoolingName(String carPoolingName) {
		this.carPoolingName = carPoolingName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public int getStartSiteId() {
		return startSiteId;
	}
	public void setStartSiteId(int startSiteId) {
		this.startSiteId = startSiteId;
	}
	public int getEndSiteId() {
		return endSiteId;
	}
	public void setEndSiteId(int endSiteId) {
		this.endSiteId = endSiteId;
	}
	@Override
	public String toString() {
		return "Carpooling [id=" + id + ", carPoolingName=" + carPoolingName + ", createTime=" + createTime
				+ ", createBy=" + createBy + ", startSiteId=" + startSiteId + ", endSiteId=" + endSiteId + "]";
	}
	
}
