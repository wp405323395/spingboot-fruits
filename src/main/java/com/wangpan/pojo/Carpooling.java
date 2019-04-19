package com.wangpan.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Carpooling {
	private String id;
	private String carPoolingName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date time;
	private List<User> passengerList;
	private User driver;
	private SiteInfo startSiteInfo;
	private SiteInfo endSiteInfo;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public List<User> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<User> passengerList) {
		this.passengerList = passengerList;
	}
	public User getDriver() {
		return driver;
	}
	public void setDriver(User driver) {
		this.driver = driver;
	}
	public SiteInfo getStartSiteInfo() {
		return startSiteInfo;
	}
	public void setStartSiteInfo(SiteInfo startSiteInfo) {
		this.startSiteInfo = startSiteInfo;
	}
	public SiteInfo getEndSiteInfo() {
		return endSiteInfo;
	}
	public void setEndSiteInfo(SiteInfo endSiteInfo) {
		this.endSiteInfo = endSiteInfo;
	}
}
