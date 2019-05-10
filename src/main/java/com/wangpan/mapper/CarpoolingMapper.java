package com.wangpan.mapper;

import java.util.List;

import com.wangpan.entity.po.Carpooling;

public interface CarpoolingMapper{
	List<Carpooling> getAllCarpooling();
	int insert(Carpooling carpooling);
}
