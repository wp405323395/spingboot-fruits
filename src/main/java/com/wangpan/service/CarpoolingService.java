package com.wangpan.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangpan.entity.Carpooling;
import com.wangpan.entity.User;
import com.wangpan.mapper.CarpoolingMapper;
import com.wangpan.mapper.SiteInfoMapper;
import com.wangpan.mapper.UserMapper;

@Service
public class CarpoolingService {
	@Autowired 
	CarpoolingMapper carpoolingMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	SiteInfoMapper siteInfoMapper;

	public Object getCarpoolingDetail() {
		List<CarpoolingDetail> carpoolingDetailList = new ArrayList<CarpoolingDetail>();
		List<Carpooling> carpoolingList = carpoolingMapper.getAllCarpooling();
		carpoolingList.forEach(carpooling->{
			CarpoolingDetail carpoolingDetail = new CarpoolingDetail();
			User driver = userMapper.findUserById(carpooling.getCreateBy());
			carpoolingDetail.setDriver(driver);
			carpoolingDetail.setCarpoolingId(carpooling.getId());
			carpoolingDetail.setCarPoolingName(carpooling.getCarPoolingName());
			carpoolingDetail.setCreateTime(carpooling.getCreateTime());
			carpoolingDetail.setPassengerList(userMapper.findByCarpoolingId(carpooling.getId()));
			carpoolingDetailList.add(carpoolingDetail);
			System.out.println(carpooling.toString());
		});
		return carpoolingDetailList;
	}
	
	public int createCarpooling(Carpooling carpooling) {
		return carpoolingMapper.insert(carpooling);
	}
	
	class CarpoolingDetail {
		private String carpoolingId;
		private String carPoolingName;
		private Date createTime;
		private User driver;
		private List<User> passengerList;
		public User getDriver() {
			return driver;
		}
		public void setDriver(User driver) {
			this.driver = driver;
		}
		public List<User> getPassengerList() {
			return passengerList;
		}
		public void setPassengerList(List<User> passengerList) {
			this.passengerList = passengerList;
		}
		public String getCarpoolingId() {
			return carpoolingId;
		}
		public void setCarpoolingId(String carpoolingId) {
			this.carpoolingId = carpoolingId;
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
	}
}
