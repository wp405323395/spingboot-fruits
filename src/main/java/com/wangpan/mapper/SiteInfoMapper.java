package com.wangpan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wangpan.entity.po.SiteInfo;

@Mapper
public interface SiteInfoMapper{
	List<SiteInfo> findAll();
	SiteInfo selectById(int id);
}
