package com.wangpan.s.carpooling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wangpan.s.carpooling.entity.po.SiteInfo;

@Mapper
public interface SiteInfoMapper{
	List<SiteInfo> findAll();
	SiteInfo selectById(int id);
}
