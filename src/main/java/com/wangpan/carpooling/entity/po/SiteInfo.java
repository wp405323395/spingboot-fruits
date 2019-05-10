package com.wangpan.carpooling.entity.po;

import java.io.Serializable;

import lombok.Data;
@Data
public class SiteInfo implements Serializable {
	private String id;
	private String siteName;
	private long longitude; //经度
	private long latitude; //纬度
	private boolean isAvailable; //站点是否可用

}
