package com.wangpan.s.carpooling.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wangpan.s.carpooling.entity.po.Carpooling;
import com.wangpan.s.carpooling.entity.po.SiteInfo;
import com.wangpan.s.user.entity.vo.UserVO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CarpoolingDetailDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
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
