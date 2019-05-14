package com.wangpan.s.carpooling.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangpan.s.carpooling.entity.dto.CarpoolingDetailDTO;
import com.wangpan.s.carpooling.entity.po.Carpooling;
import com.wangpan.s.carpooling.entity.po.SiteInfo;
import com.wangpan.s.carpooling.mapper.CarpoolingMapper;
import com.wangpan.s.carpooling.mapper.SiteInfoMapper;
import com.wangpan.s.carpooling.service.CarpoolingService;
import com.wangpan.s.user.entity.User;
import com.wangpan.s.user.entity.vo.UserVO;
import com.wangpan.s.user.mapper.UserMapper;


@Service
public class CarpoolingServiceImpl implements CarpoolingService{
	@Autowired 
	CarpoolingMapper carpoolingMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	SiteInfoMapper siteInfoMapper;
	@Autowired
	UserMapper accountMapper;
	@Override
	public Object getCarpoolingDetail() {
		List<CarpoolingDetailDTO> carpoolingDetailList = new ArrayList<CarpoolingDetailDTO>();
		List<Carpooling> carpoolingList = carpoolingMapper.getAllCarpooling();
		carpoolingList.forEach(carpooling->{
			CarpoolingDetailDTO carpoolingDetail = new CarpoolingDetailDTO();
			BeanUtils.copyProperties(carpooling, carpoolingDetail);
			//加载司机
			User driver = userMapper.findUserById(carpooling.getCreateById());
			UserVO driverVo = new UserVO();
			BeanUtils.copyProperties(driver, driverVo);
			carpoolingDetail.setDriver(driverVo);
			// 加载乘客
			List<User> userList = userMapper.findByCarpoolingId(carpooling.getId());
			List<UserVO> userVOList = new ArrayList<>();
			userList.forEach(item->{
				UserVO userVO = new UserVO();
				BeanUtils.copyProperties(item, userVO);
				userVOList.add(userVO);
			});
			carpoolingDetail.setPassengerList(userVOList);
			//加载站点
			SiteInfo startSitInfo = siteInfoMapper.selectById(carpooling.getStartSiteId());
			SiteInfo endSitInfo = siteInfoMapper.selectById(carpooling.getEndSiteId());
			carpoolingDetail.setStartSitInfo(startSitInfo);
			carpoolingDetail.setEndSitInfo(endSitInfo);
			carpoolingDetailList.add(carpoolingDetail);
		});
		return carpoolingDetailList;
	}
	
	@Override
	public int createCarpooling(Carpooling carpooling) {
		return carpoolingMapper.insert(carpooling);
	}
}
