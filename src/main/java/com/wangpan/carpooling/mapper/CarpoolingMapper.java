package com.wangpan.carpooling.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wangpan.carpooling.entity.po.Carpooling;

@Mapper
public interface CarpoolingMapper {
	List<Carpooling> getAllCarpooling();
	int insert(Carpooling carpooling);
}
