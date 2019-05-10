package com.wangpan.entity.po;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Carpooling implements Serializable {
	private String id;
	private String carPoolingName;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private int createById;
	private int startSiteId;
	private int endSiteId;
	
}
