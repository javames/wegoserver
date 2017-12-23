package com.changhong.appserver.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	private String name;

	private int id;

	private String headImage;

	private String password;

	private String authenticated;

	private String usertoken;

	
	
	
}
