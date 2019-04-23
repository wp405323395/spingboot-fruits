package com.wangpan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangpan.entity.Carpooling;
import com.wangpan.entity.SiteInfo;
import com.wangpan.entity.User;

@RestController
@RequestMapping("/carpooling")
public class CarpoolingController {
	
	@GetMapping("/queryAllCarpooling")
	public Object queryAllCarpooling() {
		List<Carpooling> carpoolingList = new ArrayList<Carpooling>();
		return "";
	}
	
	// curl -H "Content-Type: application/json" -X POST  --data '{"name":"zhangsan", "password":"123456"}' http://127.0.0.1:8986/fruits/carpooling/createCarpooling
	@PostMapping("/createCarpooling")
	public Object createCarpooling() {
		Carpooling carpooling = new Carpooling();
		carpooling.setCarPoolingName("武汉火车站的开始走啦！");
		SiteInfo endSitInfo = new SiteInfo();
		endSitInfo.setAvailable(true);
		endSitInfo.setLatitude(130);
		endSitInfo.setLongitude(2030);
		endSitInfo.setSiteName("武汉火车站");
		
		SiteInfo startSiteInfo = new SiteInfo();
		startSiteInfo.setAvailable(true);
		startSiteInfo.setLatitude(130);
		startSiteInfo.setLongitude(2030);
		startSiteInfo.setSiteName("万科花山紫月湾");
		
		carpooling.setEndSiteInfo(endSitInfo);
		carpooling.setStartSiteInfo(startSiteInfo);
		
		User user2 = new User();
		user2.setName("李四");
		user2.setUserType(1);
		user2.setCommunityName("万科");
		user2.setCreateTime(new Date());
		carpooling.setDriver(user2);
		
		carpooling.setTime(new Date());
		
		return carpooling;
		
	}
}
