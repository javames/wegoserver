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
}
