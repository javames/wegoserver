package com.changhong.appserver.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private int id;
	@Getter
	@Setter
	private String headImage;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String authenticated;
	@Getter
	@Setter
	private String usertoken;
	public UserEntity(String name, int id, String headImage, String authenticated, String usertoken,String password) {
		super();
		this.name = name;
		this.id = id;
		this.headImage = headImage;
		this.authenticated = authenticated;
		this.usertoken = usertoken;
		this.password=password;
	}
	
	
	
}
