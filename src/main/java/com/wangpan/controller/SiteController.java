package com.wangpan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangpan.entity.SiteInfo;


@RestController
@RequestMapping("/site")
public class SiteController {
	
	//curl http://localhost:8986/fruits/site/queryAllSites
	@GetMapping("/queryAllSites")
	public Object queryAllSites() {
		List<SiteInfo> siteList = new ArrayList<SiteInfo>();
		SiteInfo siteInfo = new SiteInfo();
		siteInfo.setAvailable(true);
		siteInfo.setLatitude(100);
		siteInfo.setLongitude(2030);
		siteInfo.setSiteName("联头青年城");
		
		SiteInfo siteInfo2 = new SiteInfo();
		siteInfo2.setAvailable(true);
		siteInfo2.setLatitude(100);
		siteInfo2.setLongitude(2030);
		siteInfo2.setSiteName("益达云姗瑚");
		
		SiteInfo siteInfo3 = new SiteInfo();
		siteInfo3.setAvailable(true);
		siteInfo3.setLatitude(130);
		siteInfo3.setLongitude(2030);
		siteInfo3.setSiteName("万科花山紫悦湾");

		SiteInfo siteInfo4 = new SiteInfo();
		siteInfo4.setAvailable(true);
		siteInfo4.setLatitude(130);
		siteInfo4.setLongitude(2030);
		siteInfo4.setSiteName("武汉火车站");
		
		SiteInfo siteInfo5 = new SiteInfo();
		siteInfo5.setAvailable(true);
		siteInfo5.setLatitude(130);
		siteInfo5.setLongitude(2030);
		siteInfo5.setSiteName("青山公园");
		
		siteList.add(siteInfo);
		siteList.add(siteInfo2);
		siteList.add(siteInfo3);
		siteList.add(siteInfo4);
		siteList.add(siteInfo5);
		
		return siteList;
		
	}
}
