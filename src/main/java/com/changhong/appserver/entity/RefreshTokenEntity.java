package com.changhong.appserver.entity;

import lombok.Data;

@Data
public class RefreshTokenEntity {

	private Integer id;
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String uid;
	private String current_time;
	private String refresh_expires;
	//用户的唯一标识对应于表中的usertoken
	private String unionid;
	private String code;
	
	private String name;
	private String headImage;
}
