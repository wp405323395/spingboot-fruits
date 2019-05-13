package com.wangpan.s.carpooling.entity.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wangpan.s.carpooling.entity.po.SiteInfo;
import com.wangpan.s.carpooling.entity.vo.UserVO;

import lombok.Data;

@Data
public class CarpoolingDetailDTO {
	private String id;
	private String carPoolingName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private int createById;
	private int startSiteId;
	private int endSiteId;
	private UserVO driver;
	private SiteInfo startSitInfo;
	private SiteInfo endSitInfo;
	private List<UserVO> passengerList;

}