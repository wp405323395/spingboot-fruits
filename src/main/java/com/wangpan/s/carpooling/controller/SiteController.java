package com.wangpan.s.carpooling.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangpan.s.carpooling.entity.po.SiteInfo;
import com.wangpan.s.carpooling.mapper.SiteInfoMapper;


@RestController
@RequestMapping("/site")
public class SiteController {
	@Autowired
	SiteInfoMapper siteInfoMapper;
	
	//curl http://localhost:8986/fruits/site/queryAllSites
	@GetMapping("/queryAllSites")
	public Object queryAllSites() {
		List<SiteInfo> siteList = new ArrayList<SiteInfo>();
		siteList = siteInfoMapper.findAll();
		
		return siteList;
		
	}
}
