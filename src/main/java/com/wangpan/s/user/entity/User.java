package com.wangpan.s.user.entity;

    import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author max_wang
* @since 2019-05-13
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String password;

    private String communityName;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private String userDesc;

    private Integer userType;

            /**
            * 车牌号
            */
    private String licensePlate;

            /**
            * 0：男，1：女
            */
    private Integer sex;


}
